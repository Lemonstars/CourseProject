# -*- coding:utf-8 -*-
import time
import pymongo
import shutil
import datetime


# get the date between them
def get_every_day(begin_date, end_date):
    date_list = []
    begin_date = datetime.datetime.strptime(begin_date, "%Y-%m-%d")
    end_date = datetime.datetime.strptime(end_date, "%Y-%m-%d")
    while begin_date <= end_date:
        date_str = begin_date.strftime("%Y-%m-%d")
        date_list.append(date_str)
        begin_date += datetime.timedelta(days=1)
    return date_list


if __name__ == '__main__':

    # config the mongodb connection
    client = pymongo.MongoClient("mongodb://localhost:27017/")
    db = client["aqi"]
    col = db["city"]

    # acquire the date list
    dateDuration = get_every_day('2014-01-01', '2018-10-25')

    # simulate to generate data stream
    for oneDate in dateDuration:
        fileName = oneDate + "&" + str(time.time())
        filePath = r'tmp/' + str(fileName) + '.log'
        with open(filePath, 'w') as f:
            queryAns = col.find({'date': oneDate})
            for doc in queryAns:
                print('doc=%s', doc)
                f.write(str(doc))
                f.write('\n')

        destination = shutil.move(filePath, r'log/' + str(fileName) + '.log')
        time.sleep(1)
