import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 A와 B
//https://www.acmicpc.net/problem/12904
//S->T로 만들어가면 시간초과발생한다. 왜냐하면 모든 문자열에 대해 경우의 수를 계산하여 큐에 넣어줘야 하기 때문이다.
//T->S로 만들어가면 while 한번이면 되기 때문에 쉽게 해결된다.
//문자열에 대해 많은 변경이 일어나면 String보다 StringBuilder 사용한다.
public class P12904{
	
	static String S;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P12904.txt"));
		StringBuilder T = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		S = sc.nextLine();
		T.append(sc.nextLine());
		
		while(S.length() != T.length()) {
			
		}

		if(S.equals(String.valueOf(T)))
			System.out.println(1);
		else
			System.out.println(0);
	}
}





