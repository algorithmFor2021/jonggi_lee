import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 백준 - 트리
// 그래프, DFS
//DFS를 이용하여 쉽게 풀 수 있다.
//DFS가 아닌 다른 방법을 통해 해결하려 하였으나 쉽지 않아 다른분의 케이스를 참고
//부모를 만들어 주기 위해 작은 값을 부모로 지정하였다.
//큰값을 부모로 지정할 시 stackoverflow 발생한다.
//큰값으로 할 경우 union&find 후 find를 다시 한번 해줘야 모든 노드에 대한 최상위 부모 노드를 찾을 수 있다.
//반면 작은값을 부모로 지정시 테스트케이스를 정상적으로 통과한다.
//아마 테스트 케이스가 정점의 번호가 작은 것부터 시작하기 때문에 그런거 같다.
public class P4803 {
    static int n, m;
    static int[] node;

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P4803.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = 0;

        while(true) {
            testcase++;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            if(n==0 && m==0) break;//종료

            node = new int[n+1];
            for(int i =1;i<n+1;i++) {
                node[i] = i;
            }
            
            //트리만들기
            while(m --> 0) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                union(start, end);
            }
            
            HashSet<Integer> hs = new HashSet<>();
            //트리 체크
            for(int i =1;i<n+1;i++) {
                int tmp = find(i);
                if(tmp>0)
                    hs.add(tmp);
            }
            
            //출력
            viewPrint(testcase, hs.size());
        }
        
	}

    public static void union(int start, int end) {
        int dx = find(start);
        int dy = find(end);

        //최상위 부모를 만들기 위함. 숫자가 작으면 부모
        if(dx == dy) { //부모가 같으면(최상위 부모면) 0
            node[dy] = dx;
            node[dx] = 0;
        } else if(dx > dy) {
            node[dx] = dy;
        } else {
            node[dy] = dx;
        }

    }

    public static int find(int nd) {
        if(node[nd] == nd)
            return nd;
        else
            return node[nd] = find(node[nd]);
    }

    public static void viewPrint(int testcase, int cnt) {
        System.out.print("Case " +testcase + ": ");
        if(cnt == 1) 
            System.out.println("There is one tree.");
        else if(cnt > 1)
            System.out.println("A forest of "+cnt+" trees.");
        else
            System.out.println("No trees.");
    }
}
