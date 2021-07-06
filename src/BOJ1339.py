# 백준 - 단어수학(그리디)
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



# N = int(input())
# word = []

# for _ in range(N) :
#     word.append(list(input()))

# dic = {}
# for i in range(len(word)) :
#     for j in range(len(word[i])) :
#         if word[i][j] not in dic :
#             dic[word[i][j]] = 10 ** (len(word[i])-j-1)
#         else:
#             dic[word[i][j]] += 10** (len(word[i])-j-1)

# dic = sorted(dic.items(), key=lambda x:x[1], reverse=True)
# result, num = 0, 9
# for i in range(len(dic)) :
#     result += num*dic[i][1]
#     num -= 1
# print(result)