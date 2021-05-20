import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

// 백준 - 문자열 - 추월
// 문제 이해를 못해 생각보다 오래 걸렸다.
// 예를 들어 B-C-E-D-A 순으로 나갈 경우
// A를 4대가 추월했으니 4, E를 E가 추월했으니 1
// 즉, 5로 계산 해야하는지, 아니면 그냥 추월이라는 행위를 한 댓수인 4를 구해야 하는지 헷갈렸다.
// 아래의 코드도 차량 대수가 1,000이하 이기 때문에 가능하지, 더 큰 범위일 경우 중복으로 검색하는 구간이 많기 때문에 타임아웃 발생할 거라 예상된다.
public class P2002 {
    static int N, CNT;
	public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\P2002.txt"));
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
