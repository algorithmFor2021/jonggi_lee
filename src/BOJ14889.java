import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//백준 - 스타트와 링크
//브루트포스
public class BOJ14889 {
	static int N;
	static int[] team;
	static int[][] ability;
	static int MIN = Integer.MAX_VALUE;
	static int start, link;

	public static void DFS(int player, int cnt) {
		
		if ( cnt >= N/2) {
			start = teamAbilitySum(1);
			link = teamAbilitySum(0);
			// System.out.println(Arrays.toString(team) +","+start+","+link);
			MIN = Math.min(MIN, Math.abs(start - link));
			
			return;
		}

		for(int i=player;i<team.length;i++) {
			if(team[i] == 0) {
				team[i] = 1;
				DFS(i+1, cnt + 1);
				team[i] = 0;
			}
		}
	}

	public static int teamAbilitySum(int chk) {
		int sum = 0;

		for(int i=0;i<team.length;i++) {
			if(team[i] == chk) {
				for(int j=i+1;j<team.length;j++) {
					if(team[j] == chk) {
						sum += ability[i][j] + ability[j][i];
					}
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		N = Integer.parseInt(st.nextToken());

		team = new int[N];
		ability = new int[N][N];

		for (int i=0;i<N;i++) {
			int j = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				ability[i][j++] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0, 0); //시작, 팀원수
		System.out.println(MIN);
		br.close();
	}
	
}


