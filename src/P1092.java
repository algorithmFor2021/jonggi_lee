import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class P1092{

	static int N; //크레인, 1분에 하나씩 배에 실을 수 있다.
	static int M; //박스의 수
	static String ans;
	
	static class Box {
		int num;
		int kg;
		Box(int num, int kg) {
			this.num = num;
			this.kg = kg;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\P1092.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ArrayList<Integer> crane = new ArrayList();
		
		for(int i=0;i<N;i++) {
			crane.add(sc.nextInt());
		}
		
		M = sc.nextInt();
		ArrayList<Box> box = new ArrayList(); 
		
		for(int i=0;i<M;i++) {
			box.add(new Box(0, sc.nextInt()));
		}
		
		
		Collections.sort(crane, Collections.reverseOrder());		
		Collections.sort(box, (Box b1, Box b2) -> {
			return b2.kg - b1.kg;
		});
		
		int time=0;
		if(crane.get(0) < box.get(0).kg) {
			System.out.println(-1);
		} else {
			while(box.size() > 0) {
				int craneIdx=0;
				int boxIdx=0;
				
				while(craneIdx < N) {
					if(box.size()==boxIdx)
						break;
					if(crane.get(craneIdx) >= box.get(boxIdx).kg) {
						box.remove(boxIdx);
						craneIdx++;
					} else {
						boxIdx++;
					}
				}
				time++;
			}
			System.out.println(time);
		}
		
		sc.close();
	}
}





