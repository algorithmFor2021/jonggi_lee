import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//백준 - 그래프 - 도시 분할 계획
//최소스패닝트리 - 크루스칼 알고리즘
public class P1647 {
    static int N, M;
    static int[] parent;
    static int MIN;

    static class Map implements Comparable<Map> {
        int start;
        int end;
        int cost;

        Map(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Map m) {
            return this.cost - m.cost;
        }
    }

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1647.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Map> list = new ArrayList<>();
        parent = new int[N+1];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Map(start, end, cost));
        }

        Collections.sort(list);
        
        for(int i=1;i<N+1;i++) {
            parent[i] = i;
        }

        int lastCost = 0;
        for(Map node : list) {
            int start = find(node.start);
            int end = find(node.end);

            if(start == end)
                continue;
            
            if(start>end)
                parent[start] = end;
            else
                parent[end] = start;
            lastCost = node.cost;
            MIN += node.cost;
        }

        System.out.println(MIN - lastCost);
	}

    static int find(int num) {
        if(parent[num] == num)
            return num;
        else
            return parent[num] = find(parent[num]);
    }


}
