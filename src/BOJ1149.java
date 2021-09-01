import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 - RGB거리
//DP
public class BOJ1149 {

	static int N;
	static int[][] cost;
	static int answer;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\1149.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[1001][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=3;j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		answer = 0x7FFFFFFF;

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=3;j++) {
				int min = 0x7FFFFFFF;
				 for(int k=1;k<=3;k++) {
					 if(j!=k) {
						 if(cost[i][j] + cost[i-1][k] < min) min = cost[i][j] + cost[i-1][k];
					 }
				 }
				 cost[i][j] = min;
			}
		}
		
		for(int i=1;i<=3;i++) {
			 if(cost[N][i] < answer) answer = cost[N][i];
		}
		System.out.println(answer);
	}
}
