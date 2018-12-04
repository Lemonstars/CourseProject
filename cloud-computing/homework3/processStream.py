from pyspark import SparkContext
from pyspark.streaming import StreamingContext
import os


def line_province_count(line):
    target_province = 'other'
    for province in all_province:
        if province in line:
            target_province = province
            break
    return target_province, 1


def write_rdd(rdd):
    rdd.foreachPartition(write_province)
    output_file = open(output_path + '/mf1832103.txt', 'a')
    output_file.write('\n')
    output_file.close()


def write_province(iter):
    output_data = ''
    for data in iter:
        print(data)
        province = data[0]
        number = data[1]
        pair = province + '_' + str(number) + ';'
        output_data += pair

    output_file = open(output_path + '/mf1832103.txt', 'a')
    output_file.write(output_data)
    output_file.close()


def update_function(new_value, running_count):
    if running_count is None:
        running_count = 0
    return sum(new_value, running_count)


if __name__ == "__main__":
    # read the variable file to get variables
    variable_file_path = '/home/spark/variables.txt'
    variable_file = open(variable_file_path, 'r')
    mongodb_url = variable_file.readline().strip('\n')
    mongodb_db = variable_file.readline().strip('\n')
    mongodb_collection = variable_file.readline().strip('\n')
    streaming_path = variable_file.readline().strip('\n')
    output_path = variable_file.readline().strip('\n')

    all_province = ['北京', '天津', '上海', '重庆', '河北', '山西', '辽宁', '吉林', '黑龙江',
                    '江苏', '浙江', '安徽', '福建', '江西', '山东', '河南', '湖北', '湖南',
                    '广东', '海南', '四川', '贵州', '云南', '陕西', '甘肃', '青海', '台湾',
                    '内蒙古', '广西', '西藏', '宁夏', '新疆', '香港', '澳门']

    # generate the check point file
    check_point_file = os.getcwd() + '/checkpoint_mf1832103'

    # config the spark
    sc = SparkContext("spark://192.168.68.11:7077", "ProvinceCount")
    ssc = StreamingContext(sc, 10)
    ssc.checkpoint(check_point_file)

    # basic transformation
    streaming_data = ssc.textFileStream(streaming_path)
    province_map_data = streaming_data.map(line_province_count)
    province_map_data_filter = province_map_data.filter(lambda item: item[0] != 'other')

    # compute the batch number
    province_batch_data = province_map_data_filter.reduceByKey(lambda x, y: x + y)
    province_batch_data.foreachRDD(write_rdd)

    # compute the total number
    province_total_data = province_map_data_filter.updateStateByKey(update_function)
    province_total_data.foreachRDD(write_rdd)

    # start spark streaming
    ssc.start()
    ssc.awaitTermination()
