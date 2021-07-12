import sys
#백준 - 수들의 합2
#투포인터

sys.stdin = open("E:/WebProject/newworkspace/algo/input/2003.txt")

def twoPointer():
	global cnt
	start = 0
	end = 1
	sum = su[0]

	while start<n:
		# print(start, end, sum, cnt)
		if sum == m: # m과 sum이 같을 경우
			cnt += 1
			sum, start = cal(sum, su[start], start)
			
		elif sum < m: # sum이 m보다 작을 경우, sum에 end번째 su를 더하고 end에 1을 더한다
			if end >= n: #만약 end가 n보다 같거나 크면 배열이 끝이기 때문에 더 계산할 필요 없이 종료한다.
				break
			sum += su[end]
			end += 1 
		else: # sum이 m보다 크면
			sum, start = cal(sum, su[start], start)

def cal(sum, num, start): # sum의 첫번째 더한값을 빼고, start에 1을 더한다 (이유는 중복 계산 방지를 위해 슬라이딩 방식 이용)
	return sum - num, start + 1

n, m = map(int, input().split())
su = list(map(int, input().split()))
cnt = 0
twoPointer()

print(cnt)
