

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class P2529{

	static int k;
	static char[] sign;
	static int[] arr;
	static boolean[] visit;
	static List<String> ans = new ArrayList<>();
	 
	public static void DFS(String num, int idx) {
        if (idx == k + 1) {
            ans.add(num);
            return;
        }
 
        for (int i = 0; i <= 9; i++) {
            if (visit[i]) continue;
            if (idx == 0 || ck(Character.getNumericValue(num.charAt(idx - 1)), i, arr[idx - 1])) {
            	visit[i] = true;
                DFS(num + i, idx + 1);
                visit[i] = false;
            }
        }
    }
	
	public static boolean ck(int a, int b, char c) {
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("E:\\WebProject\\newworkspace\\algo\\input\\P2529.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		sign = new char[k];
		visit = new boolean[k];
		arr = new int[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		DFS("", 0);
		
		br.close();
	}
}





