

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// 백준 - 연산자 끼워넣기(2)
// 문자열
// 브루트포스 알고리즘
// 백트래킹(DFS)
public class P15658 {
	static int N;
	static int[] num;
	static int[] sign;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void DFS(int val, int depth) {
		if(depth == N) {
			max = Math.max(val, max);
			min = Math.min(val, min);
			return;
		}
			
		for(int i=0;i<4;i++) {
			
			if(sign[i] > 0) {
				sign[i]--;
				
				if(i==0) {
					DFS(val + num[depth], depth+1);
				} else if(i==1) {
					DFS(val - num[depth], depth+1);
				} else if(i==2) {
					DFS(val * num[depth], depth+1);
				} else {
					DFS(val / num[depth], depth+1);
				}
				sign[i]++;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P15658.txt"));
				
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		num = new int[N];
		sign = new int[4];
		
		for( int i = 0;i<num.length;i++) {
			num[i] = sc.nextInt();
		}
		
		for( int i = 0;i<4;i++) {
			sign[i] = sc.nextInt();
		}
		
		DFS(num[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	
}


/*
INPUT
2
5 6
1 1 1 1


3
3 4 5
2 1 2 1

6
1 2 3 4 5 6
3 2 1 1

OUTPUT
30
-1

60
-5

72
-48
*/
