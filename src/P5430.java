import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 - AC
public class P5430 {
	
	static int N; //테스트케이스
	static String p; //명령어
	static int n; //배열개수
	
	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P5430.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc < N;tc++) {
			
			p = sc.next();
			n = sc.nextInt();  sc.nextLine();
			String[] str = sc.nextLine().replace("[", "").replace("]", "").replace(",", " ").split(" ");
			
			LinkedList<String> ll = new LinkedList();
			
			for(int i=0;i<n;i++) {
				ll.add(str[i]);
			}
			
			boolean flag = true;
			boolean err = false;
			
			for(char t : p.toCharArray()) {
				if(ll.isEmpty() && t != 'R') {
					err = true;
					break;
				}
				
				if(t == 'R') {
					flag = !flag;
					continue;
				}
				
				if(flag) {
					ll.pollFirst();
				} else {
					ll.pollLast();
				}
			}
			
			
			if(!err) {
				sb.append("[");
				
				if(ll.size() != 0) {
					if(flag) {
						sb.append(ll.pollFirst());
						while(!ll.isEmpty())							
							sb.append("," + ll.pollFirst());
						
					} else {
						sb.append(ll.pollLast());
						while(!ll.isEmpty())							
							sb.append("," + ll.pollLast());
					}
				}
				sb.append("]\n");
			} else {
				sb.append("error\n");
			}
		}
		
		
		System.out.println(sb);
	}
}














