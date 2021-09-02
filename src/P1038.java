import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 - 감소하는 수
// 브루트포스 알고리즘 / 백트래킹
public class P1038{
	static int N;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1038.txt"));
		
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt(); // 0<= N <= 1,000,000
		
		int cnt = 0;
		
		if(N < 10) { //한자리수 번째 이면 그대로
			System.out.println(N);
		} else {
			Queue<Long> q = new LinkedList<>();
			for(int i=1;i<10;i++) {
				q.offer((long)i);
				cnt++;
			}
			
			boolean flag = false;
			long nextNum = 0;
			
			while(!q.isEmpty()) {
				long num = q.poll();
				
				for(int j=0;j < (num%10);j++) {
					nextNum = num * 10 + j;
					q.offer(nextNum);
					cnt++;

					if(cnt == N) {
						flag = true;
						q.clear();
						break;
					}
						
				}
			}
			if(flag) 
				System.out.println(nextNum);
			else
				System.out.println(-1);
		}

		sc.close();
	}
	
}
