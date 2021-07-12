import sys
from typing import Deque
#백준 - 뱀과 사다리 게임
#그래프, BFS
# 딕셔너리 : key와 value 형태

sys.stdin = open("E:/WebProject/newworkspace/algo/input/16928.txt")

def bfs():
	queue = Deque()
	queue.append(1)
	visit[1] = True

	while queue:
		now = queue.popleft()

		for i in range(1,7):
			move = now + i

			if move > 100:
				continue

			if move in ladderAndSnack.keys():
				move = ladderAndSnack[move]

			if visit[move]:
				continue
			
			queue.append(move)
			visit[move] = True
			cnt[move] = cnt[now] + 1


if __name__ == '__main__':
	N, M = map(int, input().split()) # 사다리의수, 뱀의 수
	cnt = [0]*101
	visit = [False]*101
	ladderAndSnack = dict()

	for _ in range(N+M):
		s, e = map(int, input().split())
		ladderAndSnack[s] = e

	bfs()
	print(cnt[100])

