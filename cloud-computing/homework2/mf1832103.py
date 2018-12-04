import heapq
from pyspark import SparkContext, SparkConf


if __name__ == "__main__":
    # read the variable file to get variables
    variable_file_path = '/home/homework02/variables.txt'
    variable_file = open(variable_file_path, 'r')
    K = int(variable_file.readline())
    input_data_path = variable_file.readline().strip('\n')
    out_data_path = variable_file.readline().strip('\n')
    variable_file.close()

    # config SparkContext
    master = 'spark://192.168.68.11:7077'
    config = SparkConf().setAppName('TopK').setMaster(master)
    sc = SparkContext(conf=config)

    partitionTopK = sc.textFile('file://' + input_data_path)\
        .map(lambda line: (line.split(',')[0], float(line.split(',')[1])))\
        .reduceByKey(lambda a, b: a+b)\
        .mapPartitions(lambda iterator: heapq.nlargest(K, iterator, key=lambda s: s[1]))\
        .collect()
    sc.stop()

    # get the final result
    res = heapq.nlargest(K, partitionTopK, key=lambda s: s[1])

    # output the result into the target file
    out_data_path = out_data_path + '/mf1832103.txt'
    out_data_file = open(out_data_path, 'w')
    for item in res:
        out_data_file.write(item[0] + '\n')
    out_data_file.close()


