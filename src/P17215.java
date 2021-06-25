import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 - DP - 구간 합 구하기5
public class P17215 {

	static String[] arr;
	static int[] frame;
	
	public static int addPoint(int start, int end) {
		int sum = 0;
		for(int i=start;i<=start+end;i++) {
			sum += Integer.parseInt(arr[i]);
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P17215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		arr = st.nextToken().toString().split("");
		int point = 0;
		int fNum = 0;
		frame = new int[10];

		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals("S")) { //스트라이크
				point += addPoint(i, 2);
			} else if(arr[i].equals("P")) { //스페어
				point += addPoint(i, 1);
			} else if(arr[i].equals("-")) { //하나도 못 칠 경우
				
			} else { // 그외
				point += Integer.parseInt(arr[i]);
			}


		}
		
		
	}
}




