# 백준 - 두 동전
# 그래프, BFS
import sys
from collections import deque

sys.stdin = open("E:/WebProject/newworkspace/algo/input/16197.txt","r")

def BFS():
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    while coin:
        cx1, cy1, cx2, cy2, cnt = coin.popleft()

        if cnt > 10:
            return -1

        for i in range(4):
            nx1, ny1 = cx1 + dx[i], cy1 + dy[i]
            nx2, ny2 = cx2 + dx[i], cy2 + dy[i]
            # print(nx1, ny1, nx2, ny2)
            if 0<=nx1<N and 0<=ny1<M and 0<=nx2<N and 0<=ny2<M:
                if board[nx1][ny1] == '#':
                    nx1, ny1 = cx1, cy1
                if board[nx2][ny2] == '#':
                    nx2, ny2 = cx2, cy2
                coin.append((nx1, ny1, nx2, ny2, cnt+1))
            else:
                if ((0>nx1 or nx1 >=N) or (0>ny1 or ny1>=M)) and ((0>nx2 or nx2>=N) or (0>ny2 or ny2>=M)):
                    continue
                else:
                    return cnt +1
    return -1


if __name__ == "__main__":
    N, M = map(int, input().split())
    board = []
    position = []
    coin = deque()

    for i in range(N):
        board.append(list(input()))
        for j in range(M):
            if board[i][j] == 'o':
                position.append(i)
                position.append(j)
    
    coin.append((position[0], position[1], position[2], position[3], 1))
    print(BFS())
