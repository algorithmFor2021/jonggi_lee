
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 - 그래프 - 촌수계산
public class P2644 {
    static int n, m;
    static int p1, p2;
    static int[][] family;
    static int[] visit;
    static Queue<Integer> q;
    static int cnt;

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P2644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        
        family = new int[n+1][n+1];
        visit = new int[n+1];
        q = new LinkedList<>();

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            family[start][end] = 1;
            family[end][start] = 1;
        }

        q.add(p1);
        visit[p1] = 1;

        while(!q.isEmpty()) {
            int pos = q.poll();
            if(p2 == pos) {
                cnt = visit[pos];
                break;
            }
            for(int i = 1;i<n+1;i++) {
                if(family[pos][i] == 1 && visit[i] == 0) {
                    q.offer(i);
                    visit[i] = visit[pos] + 1;
                }
            }
        }

        System.out.println(cnt-1);
    }
}
