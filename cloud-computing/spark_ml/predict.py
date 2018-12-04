from pyspark.mllib.tree import DecisionTree, RandomForest
from pyspark.mllib.regression import LabeledPoint
from pyspark.sql import SparkSession


# different metric
def print_metric(predict, actual):
    tp = 0
    fn = 0
    fp = 0
    tn = 0
    for i in range(len(predict)):
        predict_result = predict[i]
        actual_result = actual[i]
        if predict_result == 1 and actual_result == 1:
            tp += 1
        elif predict_result == 0 and actual_result == 1:
            fn += 1
        elif predict_result == 1 and actual_result == 0:
            fp += 1
        else:
            tn += 1
    P = float(tp) / (tp + fp)
    R = float(tp) / (tp + fn)
    F1 = (2*P*R) / (P+R)
    print("真正例:" + str(tp))
    print("假反例:" + str(fn))
    print("假正例:" + str(fp))
    print("真反例:" + str(tn))
    print("查准率:" + str(P))
    print("查全率:" + str(R))
    print("F1:" + str(F1))


# convert RDD to LabelPoint
def rdd2label_point(row):
    return LabeledPoint(row.TenYearCHD,
                        [row.BMI, row.BPMeds, row.age, row.cigsPerDay, row.currentSmoker, row.diaBP, row.diabetes,
                         row.education, row.glucose, row.heartRate, row.male, row.prevalentHyp, row.prevalentStroke,
                         row.sysBP, row.totChol])


if __name__ == '__main__':

    # config spark
    spark = SparkSession \
        .builder \
        .appName("SparkML") \
        .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/heart_study.framingham") \
        .getOrCreate()

    # read as data frame
    data = spark.read.format("com.mongodb.spark.sql.DefaultSource").load()

    # split into training set and test set
    (trainingData, testData) = data.randomSplit([0.7, 0.3])

    # convert RDD to LabelPoint
    trainingDataRDD = trainingData.rdd.map(rdd2label_point)
    testDataRDD = testData.rdd.map(rdd2label_point)

    # info about categorical features
    category = {1: 2, 4: 2, 6: 2, 7: 4, 10: 2, 11: 2, 12: 2}

    # Train a DecisionTree model
    decision_tree_model = DecisionTree.trainClassifier(trainingDataRDD, numClasses=2, categoricalFeaturesInfo=category,
                                                       impurity='gini', maxDepth=5, maxBins=12)

    # Train a RandomForest model
    random_forest_model = RandomForest.trainClassifier(trainingDataRDD, numClasses=2, categoricalFeaturesInfo=category,
                                                       impurity='gini', maxDepth=5, maxBins=12,
                                                       numTrees=7, featureSubsetStrategy="auto")

    # the features of the test data
    testDataFeatureRDD = testDataRDD.map(lambda x: x.features)
    testDataCount = testData.count()

    # predict the result
    decision_tree_prediction = decision_tree_model.predict(testDataFeatureRDD).collect()
    random_forest_prediction = random_forest_model.predict(testDataFeatureRDD).collect()

    # metric
    testDataLabelCollect = testDataRDD.map(lambda lp: lp.label).collect()
    print("Decision Tree:")
    print_metric(decision_tree_prediction, testDataLabelCollect)
    print("===================================================")
    print("Random Forest:")
    print_metric(random_forest_prediction, testDataLabelCollect)

