import sys
#백준 - 괄호
#DP, 카탈린수
#어렵다. dp[i] %= 1000000007 부분이 잘 이해가 되지 않는다.
#값이 커질수록 long형이 범위를 초과하는건 이해가 되는데 다음 계산시 잘못된 계산이 되지 않을까 생각이 들지만
sys.stdin = open("D:/eclipse/workspace/Study/WebContent/10422.txt")


def cal():
	for i in range(2, 5001, 2):
		for j in range(2, i+1, 2):
			dp[i] += dp[j-2]*dp[i-j]
		dp[i] %= 1000000007
						
	
if __name__ == '__main__':
	T = int(input())
	dp = [0 for _ in range(5001)]
	dp[0] = 1
	
	cal()

	for _ in range(T):
		print(dp[int(input())])
