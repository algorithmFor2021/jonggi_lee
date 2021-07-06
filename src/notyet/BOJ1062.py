# 백준 - 가르침
import sys
# 문자열, 완전탐색(브루트포스)
# python3로 하면 시간 초과 발생, pypy3는 통과함.
# 간단한 코드상에서는 Python3가 메모리, 속도 측에서 우세
# 복잡한 코드(반복)을 사용하는 경우에서는 PyPy3가 우세
# 조합은 비트마스크
sys.stdin = open("E:/WebProject/newworkspace/algo/input/1062.txt","r")

def dfs(idx, cnt):
    global maxRead
    readCnt = 0
    if cnt == K-5:
        for word in words:
            readWord = 0
            for c in word:
                if not alphabet[ord(c) - ord('a')]:
                    break
                else:
                    readWord += 1

            if len(word) == readWord:
                readCnt += 1
            maxRead = max(readCnt, maxRead)
        return

    for i in range(idx, 26):
        if not alphabet[i]:
            alphabet[i] = True
            dfs(i, cnt + 1)
            alphabet[i] = False

N, K = map(int, input().split()) # 0<=N <=50, 0<=K<=26
if K < 5 or K ==26:
    print(0 if K <5 else N)
    exit(0)

words = []
for _ in range(N):
    words.append(input().replace('anta','').replace('tica',''))

alphabet = [False]*26

for c in ('a','n','t','i','c'):
    alphabet[ord(c)-ord('a')] = True

maxRead = 0
dfs(0, 0)

print(maxRead)

