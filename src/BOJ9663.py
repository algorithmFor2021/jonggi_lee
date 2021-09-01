#백준 - N-Queen
#브루트포스, 백트래킹

import sys

def check(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == x - i:
            return False
    return True


def dfs(x):
    global result
    if x == N:
        result += 1
        return

    for i in range(N):
        if visit[i]:
            continue

        row[x] = i
		
        if check(x):
            visit[i] = True
            dfs(x + 1)
            visit[i] = False

N = 8
row = [0] * N
visit = [False] * N
result = 0
dfs(0)
print(result)