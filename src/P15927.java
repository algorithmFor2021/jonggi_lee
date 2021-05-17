import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

// 백준 - 문자열 - 회문은 회문아니야!!
// 3가지 조건
// 1. 팰린드롬이 아니다  => 문자열의 길이 출력
// 2. 펠랜드롬이다.
//  2-1 팰린드롬일 경우 전부 같은 문자인지 => -1 출력
//  2-2 팰린드롬일 경우 팰린드롬이 아닌 가장 긴 부분문자열의 길이를 출력
// (ABCBA는 팰린드롬이다. 여기서 마지막 A를 제거하면 ABCB, 즉 팰린드롬이 아니다.)
public class P15927 {
    
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P15927.txt"));
		Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        
        int flag = 0;
        for(int i=0;i<msg.length()/2;i++) {
            if(msg.charAt(i) != msg.charAt(msg.length()-i-1)) {
                flag = 2;
                break;
            }
            if(msg.charAt(i) != msg.charAt(i+1))
                flag = 1;
        }

        if(flag == 0)
            System.out.println(-1);
        else if(flag == 1)
            System.out.println(msg.length()-1);
        else
            System.out.println(msg.length());
	}
	
}
