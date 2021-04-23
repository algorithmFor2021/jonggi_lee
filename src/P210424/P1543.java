package P210424;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//백준 - 문서 검색
public class P1543 {
	static String doc;
	static String word;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1543.txt"));
				
		Scanner sc = new Scanner(System.in);
		doc = sc.nextLine();
		word = sc.nextLine();
		
		int cnt = 0;
		int tmp = 0;
		
		for(int i = 0;i < doc.length()-word.length()+1;i++) {
							
			tmp = 0;
			for(int j = 0;j < word.length();j++) {
				if(doc.charAt(i+j) == word.charAt(j))
					tmp++;
				else
					break;		
			}
			

			if(tmp == word.length()) {
				cnt ++;
				i = i + word.length() + -1;
			}
			
		}
		
		System.out.println(cnt);
		sc.close();
	}
	
}
