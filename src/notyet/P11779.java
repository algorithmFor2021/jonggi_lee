package notyet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 백준 - 그래프 - 최소비용 구하기2
// 푸는중
// a-b로 가는 경로가 여러개 있다. 그래서 최소값으로 업데이트
public class P1213 {
    static int N, CNT;

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1213.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> m = new HashMap();
        
        boolean flag = true;
        String msg = "";
        char[] name = br.readLine().toCharArray();
        
        for(int i =0;i < name.length;i++) {
            m.put(name[i], m.getOrDefault(name[i], 0)+1);
        }

        char[] pel = new char[name.length];

        int forward = 0;
        int backward = name.length-1;

        for(char c : m.keySet()) {
            while(m.get(c) > 1) {
                pel[forward++] = c;
                pel[backward--] = c;
                m.put(c, m.get(c)-2);
            }
        }

        int cnt = 0;
        for(char c : m.keySet()) {
            if(m.get(c) > 0) {
                pel[forward] = c;
                cnt++;
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

/*
문자의 개수 = 2 => 앞뒤로 넣는다. 0
           > 2 => 앞뒤로 넣고 -2, 2보다 크면 또 앞뒤로 넣고 -2
           < 2 => 대기
한사이클 돈다.
2이상인 문자가 있는지 확인
없다면 문자가 1개인 갯수 체크 => > 1 => 팰린드롬 성립 안됨
                               == 1 => 가운데 넣는다.

*/