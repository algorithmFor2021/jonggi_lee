
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 백준 - 팰린드롬 만들기
//문자열
//문제의 키포인트는 정답이 여러 개일 경우 사전순으로 앞서는 것을 출력해야 한다.
//즉 문자열 생성시 사전순으로 앞서는 것들을 우선적으로 배치해야 한다.
public class P1213 {
    static int N, CNT;

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1213.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char name[] = br.readLine().toCharArray();

        int chrCnt[] = new int[26];
        boolean flag = true;
        String msg = "";
        
        for(int i =0;i < name.length;i++) {
            chrCnt[name[i]-65]++;
        }
        
        char[] pel = new char[name.length];

        int forward = 0;
        int backward = name.length-1;

        for(int i =0;i < chrCnt.length;i++) {
            while(chrCnt[i] > 1) {
                pel[forward++] = (char)(i+65);
                pel[backward--] = (char)(i+65);
                chrCnt[i] -= 2;
            }
        }

        int cnt = 0;
        for(int i =0;i < chrCnt.length;i++) {
            if(chrCnt[i] > 0) {
                pel[forward] = (char)(i+65);
                cnt++;
                chrCnt[i]--;
            }
            if(cnt > 1) {
                flag = false;
                break;
            }
        }

        if(flag) {
            for(char c : pel)
                msg += c;
            System.out.println(msg);
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
        
	}	
}
