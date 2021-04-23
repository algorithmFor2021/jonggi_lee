package P210424;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

// 백준 - 세 개의 소수 문제
// 에라토스테네스의 체 
public class P11502 {
	static int T, K;
	static boolean[] prime;
	
	public static void cal(int num) {
		prime = new boolean[num];
		prime[0] = prime[1] = true;
		
		//11까지만 구해도 모든 소수를 구할 수 있다. 그래서 i*i를 해줘서 11까지만 계산한다.
		for(int i=2;i*i<num ; i++) {
			if(!prime[i])
				for(int j=i*i;j<num ; j+=i) {
					prime[j] = true;
				}
		}		
	}
	
	public static String sosu(int num) {
		 for(int i=2;i<num;i++) {
			 if(prime[i]) continue;
			 for(int j=2;j<num;j++) {
				 if(prime[j]) continue;
				 for(int k=2;k<num;k++) {
					 if(prime[k]) continue;
					 
					 if(i+j+k == num) {
						 return i+" "+j+" "+k;
					 }
					 
				 }
			 }
				 
		 }
		 return "0";
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P11502.txt"));
				
		Scanner sc = new Scanner(System.in);
		int max = 0;
		
		T = sc.nextInt();
		
		for (int i=0;i < T;i++) {
			K = sc.nextInt();
			if(K > max) {
				max = K;
				cal(K);
			}
			
			String ans = sosu(K);
			System.out.println(ans);
		}
		
		sc.close();
	}
	
}
