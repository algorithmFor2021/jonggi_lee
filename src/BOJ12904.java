import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 A와 B
//구현, 문자열, 그리디
//S->T로 만들어가면 시간초과발생한다. 왜냐하면 모든 문자열에 대해 경우의 수를 계산하여 큐에 넣어줘야 하기 때문이다.
//T->S로 만들어가면 while 한번이면 되기 때문에 쉽게 해결된다.
//문자열에 대해 많은 변경이 일어나면 String보다 StringBuilder 사용한다.
public class BOJ12904{

	static String S;
	static String T;
	
	public static String chgStr(String str) {
		String tmpStr = "";
		
		if(str.charAt(str.length()-1) == 'A') {
			tmpStr = str.substring(0, str.length()-1);
		} else{
			tmpStr = str.substring(0, str.length()-1);
			StringBuffer sb = new StringBuffer(tmpStr);
			tmpStr = sb.reverse().toString();
		}
		System.out.println(tmpStr);
		return tmpStr;
	}
		
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\12904.txt"));
		Scanner sc = new Scanner(System.in);
		
		S = sc.nextLine();
		T = sc.nextLine();
		/*
		 * S를 T길이 만큼 모든조합 만든다.
		 * Queue를 이용
		 */
		Queue<String> q = new LinkedList();
		q.offer(T);
		
		boolean flag = false;

		while(!q.isEmpty()) {
			String tmp = q.poll();

			if(tmp.length() == S.length()) {
				if(S.equals(tmp)) {
					flag = true;
				} else {
					flag = false;
				}
				break;
			}

			if(tmp.length() > S.length()) {
				String str1 = chgStr(tmp);
				q.offer(str1);
			}
		}
		
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);

	}
}





