import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 평범한 배낭
//DP
//memorization 이용, DFS 이용시 시간 초과 발생할 수 있다.
public class BOJ12865 {
	static int N; //1<=N<=100       물품의 수
	static int K; //1<=K<=100,000   버틸 수 있는 무게
	static int[][] item;
	static int[][] backPack;
	static int max;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\12865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		item = new int[2][N+1];
		backPack = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			item[0][i] = Integer.parseInt(st.nextToken()); //물건의 무게
			item[1][i] = Integer.parseInt(st.nextToken()); //물건의 가치
		}

		for(int i=1;i<=N;i++) { //물건갯수
			for(int j=1;j<=K;j++) { //배낭무게
				if(item[0][i] <= j) {
					backPack[i][j] = Math.max(backPack[i-1][j - item[0][i]] + item[1][i], backPack[i-1][j]);
				} else {
					backPack[i][j] = backPack[i-1][j];
				}

				max = Math.max(backPack[i][j], max);
			}
		}

		for(int i=1;i<=N;i++) { //물건갯수
		}
		System.out.println(max);
	}
}





