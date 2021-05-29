import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 - 그래프 - 음식물 피하기
public class P1743 {
    static int N, M, K;
    static int[][] path;
    static int MAX;

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1743.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        path = new int[N][M];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            path[x][y] = 1;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(path[i][j] == 1) {
                    path[i][j] = 0;
                    MAX = Math.max(MAX, BFS(i, j));
                }
            }
        }

        System.out.println(MAX);
	}

    public static int BFS(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));

        int cnt = 0;
        while(!q.isEmpty()) {
            Pos garbage = q.poll();
            cnt++;
            
            int[] dx = {-1, 0, 1, 0};
            int[] dy = { 0, 1, 0,-1};

            for(int i=0;i<4;i++){
                int nx = garbage.x + dx[i];
                int ny = garbage.y + dy[i];
                if(nx > -1 && nx < N && ny > -1 && ny < M) {
                    if(path[nx][ny] != 0) {
                        q.add(new Pos(nx, ny));
                        path[nx][ny] = 0;
                    }
                }
            }
        }
        return cnt;
    }
}









