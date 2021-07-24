import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 퇴사2
//DP
//장점 : 코딩이 쉽다
//단점 : 어느 날짜인지 히스토리를 추적하기 어렵다
public class BOJ15468 {
	static int N;
	static int[] T; //기간
	static int[] P; //금액
	static int[] money;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\15468.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = new int[N+1];
		P = new int[N+1];
		money = new int[N+2];

		for(int i = 1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = N; i>0 ;i--) {
			if(i+T[i]-1 > N)
				money[i] = money[i+1];
			else
				money[i] = Math.max(money[i+1], money[i+T[i]] + P[i]);
		}
		System.out.println(money[1]);
	}
}





