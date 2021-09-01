import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 - 연구소
//그래프, 브루트포스, 

// 바이러스는 상하좌우로 퍼져나갈 수 있다,
// 새로 세울 수 있는 벽의 개수는 3개이다.
// 해결방법
// 1. 벽세우기 : 먼저 벽을 3게 새운다.
// 2. 바이러스 퍼뜨리기 : 바이러스를 퍼뜨린다.
// 3. 안전한 공간 세기 : 바이러스가 퍼지지 않은 공간의 개수를 센다.
// ** 굳이 아전한 공간 세기 메소드를 만들 필요는 없을 거 같다.
// 최초 값 입력 받을시 빈 공간을 세고, 벽 세울때 -3 하고,
// 바이러스 퍼뜨릴때 카운트를 센뒤 이 값을 빼주면 굳이
// 안전한 공간을 셀 필요는 없다.

public class BOJ14502 {
	static int N, M;
	static int max;
	static int[][] map;
	static int[][] tmpMap;
	static Queue<VirusPos> virus;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class VirusPos {
		int x;
		int y;

		VirusPos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void DFS(int depth) {
		if(depth == 3) {
			BFS();
			max = Math.max(max, safeArea());
			return;
		}

		for(int i= 0 ;i<N; i++) {
			for(int j= 0 ;j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(depth+1);
					map[i][j] = 0;
				}
			}
		}

	}

	public static void BFS() {

		copyMap();

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmpMap[i][j] == 2)
					virus.offer(new VirusPos(i, j));
			}
		}

		while(!virus.isEmpty()) {
			VirusPos nowVirus = virus.poll();

			for(int i=0;i<4;i++) {
				int nx = dx[i] + nowVirus.x;
				int ny = dy[i] + nowVirus.y;

				if(nx > -1 && nx < N && ny > -1 && ny < M) {
					if(tmpMap[nx][ny] == 0) {
						virus.offer(new VirusPos(nx, ny));
						tmpMap[nx][ny] = 2;
					}
				}
			}
		}
	}

	public static int safeArea() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmpMap[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void copyMap() {
		for(int i= 0 ;i<N; i++) {
			tmpMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\14502.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tmpMap = new int[N][M];
		virus = new LinkedList();

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int j=0;

			while(st.hasMoreTokens()) { // 0 빈칸, 1 벽, 2 바이러스
				map[i][j++] = Integer.parseInt(st.nextToken());;
			}
		}

		DFS(0);
		System.out.println(max);
	}
}





