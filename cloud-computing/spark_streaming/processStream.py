from __future__ import print_function

from pyspark import SparkContext
from pyspark.streaming import StreamingContext


def write_file(filename, iter):
    with open(filename, 'w') as f:
        for record in iter:
            print(record)
            f.write(str(record))
            f.write('\n')


def write_aqi_average_file(iter):
    filename = 'file/aqi_average.txt'
    write_file(filename, iter)


def write_six_average_file(iter):
    filename = 'file/six_average.txt'
    write_file(filename, iter)


def write_all_aqi_file(iter):
    filename = 'file/all_aqi.txt'
    write_file(filename, iter)


def write_grade_count_file(iter):
    filename = 'file/grade_count.txt'
    write_file(filename, iter)


def aqi_dict_format(x):
    items = x.split(',')
    city = items[1].split(':')[1].strip().strip('\'')
    aqi = float(items[3].split(':')[1].strip().strip('\''))
    return city, [aqi, 1]


def aqi_items_dict_format(x):
    items = x.strip().strip('}').split(',')
    city = items[1].split(':')[1].strip().strip('\'')
    # PM25,PM10,SO2,CO,NO2,O3_8h
    format_list = []
    for i in range(5, 11):
        format_list.append(float(items[i].split(':')[1].strip().strip('\'')))
    format_list.append(1)
    return city, format_list


def aqi_date_dict_format(x):
    items = x.split(',')
    city = items[1].split(':')[1].strip().strip('\'')
    date = items[2].split(':')[1].strip().strip('\'')
    aqi = float(items[3].split(':')[1].strip().strip('\''))
    return city, [date, aqi]


def aqi_grade_dict_format(x):
    items = x.split(',')
    city = items[1].split(':')[1].strip().strip('\'')
    grade = items[4].split(':')[1].strip().strip('\'')
    return city + '-' + grade, 1


def grade_result_split(x):
    city_grade = x[0].split('-')
    city = city_grade[0]
    grade = city_grade[1]
    grade_count = x[1]
    return city, (grade, grade_count)


if __name__ == "__main__":
    sc = SparkContext("local[2]", "PythonStreaming")
    ssc = StreamingContext(sc, 3)

    lines = ssc.textFileStream("log/")

    # 该处理时间段全国各个城市的AQI均值：返回字典{城市名:均值}
    # counts每一项格式（city,AQI）
    lines.map(lambda x: aqi_dict_format(x)) \
        .reduceByKey(lambda a, b: [a[0] + b[0], a[1] + b[1]]) \
        .map(lambda a: (a[0], a[1][0] / a[1][1]))\
        .foreachRDD(lambda rdd: rdd.foreachPartition(write_aqi_average_file))

    # 该处理时间段某个城市六项值的均值：返回字典{六项值名: 均值}
    # counts每一项格式（city,[PM25,PM10,SO2,CO,NO2,O3_8h]）
    lines.map(lambda x: aqi_items_dict_format(x)) \
        .reduceByKey(lambda a, b: [a[i] + b[i] for i in range(7)]) \
        .map(lambda a: (a[0], [a[1][i] / a[1][6] for i in range(6)]))\
        .foreachRDD(lambda rdd: rdd.foreachPartition(write_six_average_file))

    # 该处理时间段某个城市时间和对应AQI的值：返回字典{时间: AQI}
    # counts每一项格式（city,[date,aqi]）
    lines.map(lambda x: aqi_date_dict_format(x)) \
        .foreachRDD(lambda rdd: rdd.foreachPartition(write_all_aqi_file))

    # 某个城市grade与各grade累计出现的比率：返回字典{grade名: 比率}
    # counts每一项格式(city,(grade,count))
    lines.map(lambda x: aqi_grade_dict_format(x)) \
        .reduceByKey(lambda a, b: a + b) \
        .map(lambda x: grade_result_split(x)) \
        .foreachRDD(lambda rdd: rdd.foreachPartition(write_grade_count_file))

    ssc.start()
    ssc.awaitTermination()
