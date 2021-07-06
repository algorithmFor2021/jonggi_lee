# 백준 - 단어수학(그리디)
# 그리디
import sys

sys.stdin = open("D:/eclipse/workspace/Study/WebContent/P1339.txt", 'r')

n = int(input())
words = []

for _ in range(n):
    words.append(input())

alphaDict={}
for word in words:
    k = len(word)-1
    for s in word:
        if s in alphaDict:
            alphaDict[s] += pow(10,k)
        else:
            alphaDict[s] = pow(10,k)
        k -= 1

nums = []
for value in alphaDict.values():
    nums.append(value)

nums.sort(reverse=True)

t = 9
totalSum = 0
for i in nums:
    totalSum += i*t
    t -= 1

print(totalSum)
