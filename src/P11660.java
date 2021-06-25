import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - DP - 구간 합 구하기5
public class P11660 {

	static int N, M;
	static int[][] Map;
	static int[] pos;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P11660.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N+1][N+1];
		pos = new int[4];

		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int j=1;
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				Map[i][j] = Map[i-1][j] + Map[i][j-1] - Map[i-1][j-1] + num;
				j++;
			}
		}

		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				pos[j++] = Integer.parseInt(st.nextToken());
			}

			int sum =0;
			sum = Map[pos[2]][pos[3]] - Map[pos[2]][pos[1]-1] - Map[pos[0]-1][pos[3]] + Map[pos[0]-1][pos[1]-1];
			System.out.println(sum);
		}

	}
}




