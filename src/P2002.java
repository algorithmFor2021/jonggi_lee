import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

// 백준 - 문자열 - 추월
// 헷갈렸던 문제
// 예를 들어 C-D-B-E-A의 경우, C가 A,B를 추월했거, D가 A,B를 추월했고, B와 E가 A를 추월했으니 6인지
// 아니면 추월이라는 행위를 한 차량 댓수를 구해야 하는지 헷갈렸음
public class P2002 {
    static int N, CNT;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P2002.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();sc.nextLine();
        
        Map<String, Integer> in = new LinkedHashMap();
        ArrayList<Integer> out = new ArrayList();
        IntStream.range(0, N).forEach((i) -> in.put(sc.nextLine(), i));

        for(int j=0;j<N;j++) {
            String num = sc.nextLine();
            out.add(in.get(num));
        }

        CNT = 0;
        for(int i=0;i<N-1;i++) {
            for(int j = i+1;j<N;j++) {
                if(out.get(i) > out.get(j)) {
                    CNT++;
                    break;
                }
            }
        }
        System.out.println(CNT);
	}	
}
