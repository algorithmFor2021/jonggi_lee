package P210424;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//백준 - 도영이가 만든 맛있는 음식
public class P2961 {
	static int N, S, B;
	static int[][] food;
	static int[] mix;
	static int min = Integer.MAX_VALUE;
			
	public static void DFS(int s, int b, int cha, int depth) {
		if(N <= depth) {
			min = Math.min(min, cha);
			return;
		}
		
		for(int i=0;i<N ;i++) {
			if(mix[i] != 1) {
				mix[i] = 1;
				min = Math.min(min, Math.abs((s * food[i][0]) -(b + food[i][1])));
				Math.abs(food[i][0]-food[i][1]);
				DFS(s * food[i][0], b + food[i][1], Math.abs((s * food[i][0]) -(b + food[i][1])), depth+1);
				mix[i] = 0;
			}
		}
	}
    
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P2961.txt"));
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		food = new int[N][2];
		mix = new int[N];
		
		
		for(int i = 0 ;i<N; i++) {
			S = sc.nextInt();
			B = sc.nextInt();
			food[i][0] = S;
			food[i][1] = B;
		}
		sc.close();
		
		DFS(1, 0, 0, 0);
		System.out.println(min);
	}
}



