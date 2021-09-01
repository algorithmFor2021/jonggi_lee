import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 - 구간 합 구하기
//세그먼트 트리
public class BOJ2042{
	
	static int N, M, K;
	static long[] su;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\2042.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); //수의 개수
		M = Integer.parseInt(st.nextToken()); //수의 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수
		
		su = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			su[i] = Long.parseLong(br.readLine());
		}
		
		//트리 사이즈 구하기
		//2^k>=N
		//양변에 log 취하면 k >= logN/log2
		//올림한다.
		//구한 값에 1을 더하고 1에 대해 시프트하면 트리의 사이즈가 나온다.
		//구글링 결과 아래의 계산식이 이해가 안간다면 N*4를 해도 된다.
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = 1 << (h+1);
		tree = new long[tree_size];

		//트리 초기화
		init(1, 1, N);
		
		//숫자 변경 및 구간 합
		int gubun=0;
		int num1=0;
		long num2=0;
		int loop= M+K;
		
		while(loop-- > 0) {
			System.out.println(Arrays.toString(tree));
			st = new StringTokenizer(br.readLine());
			gubun = Integer.parseInt(st.nextToken());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Long.parseLong(st.nextToken());
			
			if(gubun == 1) { //숫자 변경
				long dif = num2 - su[num1];
				su[num1] = num2;
				update(1, N, 1, num1, dif);
			} else { //구간 합
				long dap;
				dap = sum(num1, (int)num2, 1, 1, N);
				sb.append(dap+"\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void init(int nodeNum, int start, int end) {
		if(start == end) {
			tree[nodeNum] = su[start];
		} else {
			int mid = (start+end)/2;
			init(nodeNum*2, start, mid);
			init(nodeNum*2+1, mid+1, end);
			tree[nodeNum] = tree[nodeNum*2] + tree[nodeNum*2+1];
		}
	}

	
	public static long sum(int L, int R, int nodeNum, int nodeL, int nodeR) {
		if(R < nodeL || nodeR < L) return 0; //범위 밖일 경우
		if(L <= nodeL && nodeR <= R) return tree[nodeNum]; //범위 안일 경우
		
		int mid = (nodeL + nodeR) / 2;
		long m1 = sum(L, R, nodeNum*2, nodeL, mid);
		long m2 = sum(L, R, nodeNum*2+1, mid+1, nodeR);
		return m1+m2;
	}
	
	public static void update(int nodeL, int nodeR, int nodeNum, int index, long dif) {
		if(index < nodeL || nodeR < index) return;

		tree[nodeNum] += dif;
		if(nodeL==nodeR) {
			return;
		}
		
		int mid = (nodeL+nodeR) / 2;
		update(nodeL, mid, nodeNum*2, index, dif);
		update(mid+1, nodeR, nodeNum*2+1, index, dif);
	}
	
}
