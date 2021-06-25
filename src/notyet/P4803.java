package notyet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 백준 - 그래프 - 트리
// 푸는중
public class P4803 {
    static int n=1, m=1, CNT;
    static int[] node;
    static int[] visit;

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P4803.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = 0;

        while(true) {
            CNT = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            testcase++;

            if(n==0 && m==0) break;

            node = new int[n+1];
            visit = new int[n+1];
            for(int i =1;i<n+1;i++) {
                node[i] = i;
            }
            
            for(int i =0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                if(visit[start] == 0) {
                    CNT++;
                    visit[start] = 1;
                }
                int dx = find(start);
                int dy = find(end);

                if(dx > dy)
                    node[dy] = dx;
                else
                    node[dx] = dy;
                visit[end] = 1;

                
                System.out.println("start:"+start+",end:"+end+", " +dx +","+dy);
                System.out.println(Arrays.toString(node));
                

                if(dx == dy) {
                    System.out.println("dd");
                    CNT -= 1;
                    continue;
                }
            }

            for(int i =1;i<n+1;i++) {
                if(visit[i] == 0)
                    CNT++;
            }
            System.out.println(Arrays.toString(node));

            System.out.print("Case " +testcase + ": ");
            if(CNT == 1) 
                System.out.println("There is one tree.");
            else if(CNT > 1)
                System.out.println("A forest of "+CNT+" trees.");
            else
                System.out.println("No trees.");
        }
        
	}

    public static int find(int nd) {
        if(node[nd] == nd)
            return nd;
        else
            return node[nd] = find(node[nd]);
    }
}
