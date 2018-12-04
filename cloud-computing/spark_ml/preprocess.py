import pymongo
import csv

if __name__ == '__main__':

    csv_reader = csv.reader(open('framingham.csv'))
    index = 0
    data = []
    for line in csv_reader:
        if index == 0:
            index += 1
            continue
        else:
            index += 1
            data.append(line)

    cleanData = []
    for data_line in data:
        isDrop = False
        for feature in data_line:
            if feature == 'NA':
                isDrop = True
                break
        if not isDrop:
            cleanData.append(data_line)

    # config the mongodb connection
    client = pymongo.MongoClient("mongodb://localhost:27017/")
    db = client["heart_study"]
    col = db["framingham"]

    for item in cleanData:
        insert_dict = {'male': int(item[0]), 'age': int(item[1]), 'education': int(item[2]),
                       'currentSmoker': int(item[3]), 'cigsPerDay': int(item[4]), 'BPMeds': int(item[5]),
                       'prevalentStroke': int(item[6]), 'prevalentHyp': int(item[7]), 'diabetes': int(item[8]),
                       'totChol': int(item[9]), 'sysBP': float(item[10]), 'diaBP': float(item[11]),
                       'BMI': float(item[12]), 'heartRate': int(item[13]), 'glucose': int(item[14]),
                       'TenYearCHD': int(item[15])}
        print(insert_dict)
        col.insert_one(insert_dict)



