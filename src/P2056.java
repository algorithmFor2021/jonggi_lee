import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 - 그래프 - 작업
//위상정렬 : 작업의 순서대로 나열하는 알고리즘
//조건 : 방향이 있으며 사이클이 없는 그래프(시작점이 존재해야 한다.)
//visit 처리를 안해도 된다.
//https://ssungkang.tistory.com/entry/Algorithm-%EC%9C%84%EC%83%81%EC%A0%95%EB%A0%AC
// dfs와 큐로 구현할 수 있다.
//https://jason9319.tistory.com/93
//https://ghkvud2.tistory.com/62
public class P2056 {
    static int N, minTime;
    static int[] time;
    static int[] degree;
    static int[] result;
    static ArrayList<Integer>[] node;

    public static void Solution() {
        Queue<Integer> q = new LinkedList();

        for(int i = 1;i<N+1;i++) {
            if(degree[i] == 0) {
                q.offer(i);
                result[i] = time[i];
            }
        }
        
        //사이클이 아닐 경우, 사이클이 발생할 수도 있을 경우 while문 사용 금지
        while(!q.isEmpty()) {
            int parentNode = q.poll();
            
            for(int i = 0;i<node[parentNode].size();i++) {
                int childNode = node[parentNode].get(i);
                --degree[childNode];

                if (result[childNode] < time[childNode] + result[parentNode])
                    result[childNode] = time[childNode] + result[parentNode];
                    
                if(degree[childNode] == 0) {
                    q.offer(childNode);
                }
            }
        }

        for(int i = 1;i<N+1;i++) {
            minTime = Math.max(minTime, result[i]);
        }

    }

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P2056.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        node = new ArrayList[N+1];
        time = new int[N+1];
        degree = new int[N+1];
        result = new int[N+1];

        for(int i = 1;i<N+1;i++) {
            node[i] = new ArrayList();

            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            int parentCnt = Integer.parseInt(st.nextToken());
            degree[i] = parentCnt;

            for(int j=0;j<parentCnt;j++) {
                int parentNode = Integer.parseInt(st.nextToken());
                node[parentNode].add(i);//부모와 자식을 연결
            }
        }

        Solution();
        //System.out.println(Arrays.toString(result));
        System.out.println(minTime);

	}	
}
