import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - Two dots
//그래프, BFS
//0,0부터 사이클을 만들 수 있는지 확인(사이클 구성하는 최소 개수는 4개)
//인접하는 것부터(4개) 체크
//이렇게 하면 인접한 것끼리의 사이클은 체크되나 큰 사이클(직사각형, 정사각형), 그리고 여러변으로 구성된 사격형의 경우 체크를 하지 못한다.
//그래서 인접한것 하나 체크 하고 같으면 재귀 호출하면서 지속적으로 범위를 늘려 나간다.
//

public class BOJ16929 {
	static int N, M;
	static int max;
	static char[][] map;
	static boolean[][] visitMap;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static boolean DFS(int px, int py, int x, int y, char color) {

		//현재 위치를 방문한 적이 있다면, 즉 사이클이 구성되었다면 끝
		if(visitMap[x][y])
			return true;

		visitMap[x][y] = true;

		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			//이전 경로는 제외
			if(px==nx && py==ny)
				continue;

			if(nx>-1 && nx<N && ny>-1 && ny<M) { 
				if(color == map[nx][ny]) {//color이 같으면(버릇처럼 방문한 적이 없을 때만 통과하게 했다.ㅜㅜ )
					if(DFS(x, y, nx, ny, map[nx][ny]))
						return true;
					// else  else에 false를 return 으로 전달하면 안된다. true일 경우에만 전달해야 한다.
					// 	return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\16929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visitMap = new boolean[N][M];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			while(st.hasMoreTokens()) {
				map[i] = st.nextToken().toCharArray();
			}
		}

		boolean flag = false;

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visitMap[i][j]) {
					if(DFS(-1, -1, i, j, map[i][j])) {
						flag = true;
						break;
					}
				}
			}
			if(flag)
				break;
		}
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}

