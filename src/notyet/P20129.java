package notyet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 - 문자열 - 뒤집힌 계산기
// 스택에 넣어 계산 필요
// 숫자 앞에 0이 있을 경우 삭제 필요
// 숫자와 부호 분리 위해
// 입력 받은 문자열에서 기호를 replace 처리 하여 분리
// 입력 받은 문자열에서 기호만 따로 추출
// 문제해결 방법1
// 중위표현을 후위표현으로
// 중위, 후위 알고리즘 공부
// 문제해결 방법2
// 수식 파서 트리
public class P20129 {
    static int N, CNT;

	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P20129.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] sign = new String[4];

        for(int i=0;i<sign.length;i++) {
            int n = 4 - Integer.parseInt(st.nextToken());
            if(i==0) 
                sign[n] = "+";
            else if(i==1)
                sign[n] = "-";
            else if(i==2)
                sign[n] = "*";
            else
                sign[n] = "/";
        }
        String abc="0003";
        System.out.println(Integer.parseInt(abc));
        //char[] susic = new StringBuilder(br.readLine()).reverse().toString().toCharArray();

       // for(int i=0;i<susic.length;i++) {

        //}


        //System.out.println(Arrays.toString(susic));
	}	
}
