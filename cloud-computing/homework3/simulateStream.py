import pymongo
import shutil
import time
import os

if __name__ == "__main__":
    # read the variable file to get variables
    variable_file_path = '/home/spark/variables.txt'
    variable_file = open(variable_file_path, 'r')
    mongodb_url = variable_file.readline().strip('\n')
    mongodb_db = variable_file.readline().strip('\n')
    mongodb_collection = variable_file.readline().strip('\n')
    streaming_path = variable_file.readline().strip('\n')

    # config the mongodb connection
    client = pymongo.MongoClient("mongodb://" + mongodb_url)
    db = client[mongodb_db]
    collection = db[mongodb_collection]

    # judge whether the tmp directory exists
    tmp_file_path = os.getcwd() + '/tmp_mf1832103'
    if not(os.path.exists(tmp_file_path)):
        os.mkdir(tmp_file_path)

    # simulate the stream and write file
    index = 1
    all_province = ['北京', '天津', '上海', '重庆', '河北', '山西', '辽宁', '吉林', '黑龙江',
                    '江苏', '浙江', '安徽', '福建', '江西', '山东', '河南', '湖北', '湖南',
                    '广东', '海南', '四川', '贵州', '云南', '陕西', '甘肃', '青海', '台湾',
                    '内蒙古', '广西', '西藏', '宁夏', '新疆', '香港', '澳门']

    count = 0
    for content in collection.find():
        head_text = content['head']['text']
        print(head_text)

        if index % 50 == 1:
            log_file_name = 'head_' + str(time.time()) + '.log'
            log_file_tmp_path = tmp_file_path + '/' + log_file_name
            log_file = open(log_file_tmp_path, 'w')
            log_file.write(head_text + '\n')
        elif index % 50 == 0:
            log_file.write(head_text + '\n')
            log_file.close()
            log_file_path = streaming_path + '/' + log_file_name
            shutil.move(log_file_tmp_path, log_file_path)
            time.sleep(1)
        else:
            log_file.write(head_text + '\n')

        index = index + 1

