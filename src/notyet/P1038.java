package notyet;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// 백준 - 감소하는 수
// 브루트포스 알고리즘 / 백트래킹
// 못품
public class P1038{
	static int N;
	
	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1038.txt"));
				
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt(); // 0<= N <= 1,000,000
		int cnt = 0;
		long val = 0;
		long num = 10;
		
		if(N > 1022)
			System.out.println(-1);
		else if(N < 9)
			System.out.println(N);
		else
			

		
		
		
		sc.close();
	}
	
}
