import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 - DP - 로봇 조종하기
//BFS, DFS 로 고민하였으나 시간초과가 예상되어 다른 방식으로 접근하려 하였으나
//시간초과. 그래서 다른 사람 풀이 참조하여 작성함.
public class P2169 {
	static int N, M;
	static int[][] map;
	static int[][] tmp;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\P2169.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(sc.nextLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		tmp[0][0] = map[0][0];
		for (int i = 1; i < M; i++) {
			tmp[0][i] = tmp[0][i - 1] + map[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					tmp[i][j] = tmp[i - 1][j] + map[i][j];
					continue;
				}
				tmp[i][j] = Math.max(tmp[i - 1][j], tmp[i][j - 1]) + map[i][j];
			}
			int leftVal = 0;
			for (int j = M - 1; j > -1; j--) {
				if (j == (M - 1)) {
					leftVal = tmp[i - 1][j] + map[i][j];
					tmp[i][j] = Math.max(leftVal, tmp[i][j]);
					continue;
				}
				leftVal = Math.max(tmp[i - 1][j], leftVal) + map[i][j];
				tmp[i][j] = Math.max(leftVal, tmp[i][j]);
			}
		}
		System.out.println(tmp[N - 1][M - 1]);
	}

}
