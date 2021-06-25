import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// 백준 - 숨바꼭질
// bfs + 그래프
public class P1697{
	static int N, K;

	static class Pos {
		int pos;
		int cnt;

		Pos(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
	}

	public static int BFS() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(N, 0));
		Map<Integer, Integer> m = new LinkedHashMap<>();
		m.put(N, 0);

		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.pos == K)
				return p.cnt;

			for(int i=0;i<3;i++) {
				int next = 0;
				if(i==0)
					next = p.pos-1;
				if(i==1)
					next = p.pos+1;
				if(i==2)
					next = p.pos*2;

				if(next > -1 && next < 100001 && m.get(next) == null) {
					q.add(new Pos(next, p.cnt+1));
					m.put(next, 0);
				}
			}
		}
		return 0;
	}


	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1697.txt"));
				
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt(); // 0 ≤ N ≤ 100,000
		K = sc.nextInt(); // 0 ≤ K ≤ 100,000
		
		int ans = BFS();

		System.out.println(ans);
		
		sc.close();
	}
	
}
