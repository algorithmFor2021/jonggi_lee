import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//백준 - 적록색약
//너비우선탐색
//메모리 초과 이슈 발생 - 방문 여부 체크시 큐에서 꺼낼때 체크하지 않고 큐에 넣을때 체크
public class BOJ10026 {
	static int N; //1 <= N <= 100
	static char[][] grid;
	static int[][] visit;

	static class Pos {
		int x;
		int y;
		char color;

		Pos(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

	public static int BFS() {
		//왼쪽, 오른쪽, 위, 아래
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};

		int cnt = 0;
		Queue<Pos> q = new LinkedList<>();

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {

				if(chkVisit(i, j)) {
					continue;
				}
				
				q.offer(new Pos(i,j, grid[i][j]));
				visit[i][j] = 1;

				while(!q.isEmpty()) {
					Pos p = q.poll();

					if(grid[p.x][p.y] == 'G')
						grid[p.x][p.y] = 'R';

					for(int k=0;k<4;k++) {
						int nx = p.x + dx[k];
						int ny = p.y + dy[k];
						if(0<=nx && nx<N && 0<=ny && ny<N) { //경계안에 들어오면
							if(!chkVisit(nx, ny) && p.color == grid[nx][ny]) {//방문안했고 색상이 같다면
								visit[nx][ny] = 1;
								q.add(new Pos(nx, ny, grid[nx][ny]));
							}
						}
					}
				}

				cnt++;
			}
		}

		return cnt;
	}

	public static Boolean chkVisit(int i, int j) {
		if(visit[i][j] != 0)
			return true;//방문함
		return false;//방문안함
	}


	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\10026.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visit = new int[N][N];

		for(int i=0;i<N;i++) {
			grid[i] = br.readLine().toCharArray();
		}

		int normalCnt = BFS();

		for(int []i : visit)
			Arrays.fill(i, 0);

		int rgcwCnt = BFS();

		System.out.println(normalCnt +" " + rgcwCnt);
	}
}




