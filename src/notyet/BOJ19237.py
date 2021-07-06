# 백준 - 어른상어()
import sys
sys.stdin = open("D:/eclipse/workspace/Study/WebContent/19237.txt","r")

N, M, K = map(int, input().split())
land = [list(map(int, input().split())) for _ in range(N)]
look = list(map(int, input().split()))
shark = {} # 상어번호 : 방향, x값, y값 
direction = {}

dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]

for i in range(N):
    for j in range(N):
        if land[i][j]:
            shark[land[i][j]] = {'drt':look[land[i][j]-1], 'pos' : [i, j]}

for i in range(M):
    for j in range(1,5):
        if direction.get(i+1):
            direction.get(i+1).append(list(map(int, input().split())))
        else:
            direction[i+1] = [list(map(int, input().split()))]

print(direction)

