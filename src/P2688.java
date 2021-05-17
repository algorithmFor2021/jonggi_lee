import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 - DP - 줄어들지 않아
public class P2688 {
	
	static int N;
	static long ans;
	static long[] arr;
	static long[] tmp;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P2688.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			// 초기화
			arr = new long[10+1];
			tmp = new long[10+1];
			Arrays.fill(arr, 1);
			arr[0] = 0;
			
			int num = sc.nextInt();
			
			
			if(num== 1) {
				System.out.println(10);
				continue;
			}
			ans = 10;
			
			for(int j=0;j < num-1;j++) {
				long val = ans;
				ans = 0;
				for(int k=1;k < 11;k++) {
					val -= arr[k-1];
					tmp[k] = val;
					ans += val;
				}
				arr = Arrays.copyOfRange(tmp, 0, tmp.length);
				
			}
			
			System.out.println(ans);
		}
		
		
	}

}
