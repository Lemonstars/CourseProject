import sys

# read the file path
filePath = sys.argv[1]

# read the file and generate data in memory
allData = []
f = open(filePath, 'r')
K = int(f.readline())
data = f.readline()
while data:
    allData.append(float(data))
    data = f.readline()
f.close()

# iterate to get the top K item
topK = []
for item in allData:
    currentLen = len(topK)

    isBiggerThanLast = (currentLen == K) and (item > topK[K - 1])

    # use the binary method to find the target index
    targetIndex = -1
    if currentLen == 0 or item > topK[0]:
        targetIndex = 0
    elif currentLen < K and item < topK[currentLen-1]:
        targetIndex = currentLen
    elif currentLen < K or isBiggerThanLast:
        i = 0
        j = currentLen - 1
        while i+1 < j:
            middleIndex = i + (j-i)//2
            middle = topK[middleIndex]
            if middle > item:
                i = middleIndex
            else:
                j = middleIndex
        targetIndex = j

    # In fact, the time complexity of insert in Python is O(N),
    # to decrease the time complexity, it's better to implement
    # the linked list to insert which is O(1)
    if targetIndex != -1:
        topK.insert(targetIndex, item)

    # to ensure the size of TopK is K
    if isBiggerThanLast:
        topK.pop()

# output the result
for i in range(K):
    print(topK[i], end='')
    if i != K-1:
        print(",", end='')

