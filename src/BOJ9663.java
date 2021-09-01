import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//백준 - N-Queen
//브루트포스, 백트래킹

public class BOJ9663 {
	static int N;
	static int[] arr;
	static boolean[] visit;
	static int cnt = 0;
 
	public static void nQueen(int depth) {
		
		if(depth == N) {
			cnt++;
			return;	
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i])
                continue;

			arr[depth] = i; //배열 인덱스는 열, 값은 행
			
			if(isOk(depth)) {
				visit[i] = true;
				nQueen(depth+1);
				visit[i] = false;
			}
		}
		
	}
	
	public static boolean isOk(int depth) {
		
		for(int i=0;i<depth;i++) {
			if(arr[i] == arr[depth])
				return false;
			
			if(Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\9663.txt"));
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr = new int[N]; //값은 행, 배열은 열
		visit = new boolean[N];
 
		nQueen(0);
		System.out.println(cnt);
 
	}
}







