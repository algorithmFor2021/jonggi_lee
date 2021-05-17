import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//백준 - 그리디 - 사과나무
public class P19539 {

	static int N; //사과나무의 개수
	static String ans;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\P19539.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int w1 = 1;
		int w2 = 2;
		int total = 0;
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			total += num;
			cnt += num/2;
		}
		//뒤 조건문은 이해가 잘 안됨
		if(total%(w1+w2) == 0 && cnt>= total/(w1+w2)) {
			ans = "YES";
		} else {
			ans = "NO";
		}
		
		
		System.out.println(ans);
	}
}




