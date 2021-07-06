package notyet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 - 점프점프
//DP
public class P11060 {
	static int N; //1 <= N <= 10000
	static int[] miro; //0 <= A <= 100
	static int[] ans;


	static class Pos {
		int position;
		int jump;

		Pos(int position, int jump) {
			this.position = position;
			this.jump = jump;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\11060.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		miro = new int[N];
		ans = new int[N];

		st = new StringTokenizer(br.readLine());
		int i=0;
		while(st.hasMoreTokens()) {
			miro[i++] = Integer.parseInt(st.nextToken());
		}

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0));

		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(miro[p.position] == 0)
				continue;
			
			for(int pos = miro[p.position];pos < p.position + miro[p.position];pos++) {

			}
		}

		System.out.println(ans[N-1]);
	}
	
}




