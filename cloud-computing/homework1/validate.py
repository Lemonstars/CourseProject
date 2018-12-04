import sys
import heapq

# read the file path and argument K
filePath = sys.argv[1]
f = open(filePath, 'r')
K = int(f.readline())

# read file data into python list
allData = []
data = f.readline()
while data:
    allData.append(float(data))
    data = f.readline()
f.close()

# use native method
topK = heapq.nlargest(K, allData)
for i in range(K):
    print(topK[i], end='')
    if i != K-1:
        print(",", end='')
