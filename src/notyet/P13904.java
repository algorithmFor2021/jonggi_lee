package notyet;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 - 그리디 - 과제
//https://www.acmicpc.net/problem/13904
//못품
public class P13904{
	
	static String S;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P13904.txt"));
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





