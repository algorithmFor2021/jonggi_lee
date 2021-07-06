package notyet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 - 새로운 하노이 탑
//DP
public class BOJ12906 {
	 static char[][] tower;
	 static int a, b, c;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\12906.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		tower = new char[3][11];

		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());

			String tmp = String.valueOf(st.nextToken());
			tower[i] = tmp.toCharArray();
			System.out.println(Arrays.toString(tower[i]));
		}
		
	}
	
}



/*
public class Hanoi {

	static int N, ans;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new java.io.FileInputStream("D:\\eclipse\\workspace\\SWCert\\Hanoi.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Hanoi(N, 1, 2, 3);
		
		System.out.println(ans);
		System.out.println(sb);
	}
	
	static void Hanoi(int N, int start, int mid, int to) {
		 
		// 이동할 원반의 수가 1개라면?
		if (N == 1) {
			sb.append(start + " " + to+"\n");
			//System.out.println(start + " " + to);
			ans++;
			return;
		} 
	    
		// STEP 1 : N-1개를 A에서 B로 이동
		Hanoi(N - 1, start, to, mid);
	    
		// STEP 2 : 1개를 A에서 C로 이동
		sb.append(start + " " + to+"\n");
		//System.out.println(start + " " + to);
	    ans++;
		// STEP 3 : N-1개를 B에서 C로 이동
		Hanoi(N - 1, mid, start, to);
		
	}
}
*/