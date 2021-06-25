# 백준 - 부분수열의 합(브루트포스)
def dfs(idx, sum):
    global cnt
    if idx >= N:
        return
    sum += su[idx]
    if sum == S:
        cnt+=1
    dfs(idx + 1, sum-su[idx])
    dfs(idx + 1, sum)
    

N, S = map(int, input().split())
su = list(map(int, input().split()))
cnt = 0

dfs(0, 0)
print(cnt)