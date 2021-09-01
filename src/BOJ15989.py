import sys
sys.stdin = open("C:\\Users\\leejk\\Downloads\\15989.txt")

T = int(input())
arr = [1] * 10001

for i in range(2, 4):
    for j in range(i, 10001):
        if i <= j:
            arr[j] += arr[j-i]

for _ in range(T):
    n = int(input())
    print(arr[n])

# 구하려는 수에 대해 1로 구할 수 있는 갯수를 구하고
# 그 다음에 1,2로 구할 수 있는 개수를 구하고
# 그 다음에 1,2,3으로 구할 수 있는 개수를 구한다.

# 	0	1	2	3	4	5	6	7 구하려는 수
# 0	0	0	0	0	0	0	0	0
# 1	1	1	1	1	1	1	1	1
# 2	1	1	2	2	3	3	4	4
# 3	1	1	2	3	4	5		
# 사용한 숫자
