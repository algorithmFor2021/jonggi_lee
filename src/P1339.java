import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

//백준 - DP - 구간 합 구하기5
public class P1339 {

	static int N;
	static HashMap<Integer, Map<String, Integer>> wordMap;
	static int[] pos;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P1339.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = Integer.parseInt(st.nextToken());
		wordMap = new HashMap<>();
		
		for(int i=0;i<cnt;i++) {
			st = new StringTokenizer(br.readLine());
			String word = String.valueOf(st.nextToken());
			
			

		// 	for(int j=word.length();j>0;j--) {

		// 		String tmp = String.valueOf(word.charAt(word.length()-j));
		// 		Map<String, Integer> wordCnt = new HashMap();

		// 		if(wordMap.get(j) == null) {
		// 			wordCnt.put(tmp, 1);
		// 		} else {
		// 			wordCnt = wordMap.get(j);
		// 			wordCnt.put(tmp, wordCnt.getOrDefault(tmp, 0)+1);
		// 		}
				
		// 		wordMap.put(j, wordCnt);
		// 	}
		// }
		
		// ArrayList<Integer> arr = new ArrayList(wordMap.keySet());
		// Collections.reverse(arr);//arr.sort(Collections.reverseOrder());

		// for(int i : arr) {
		// 	for(String j : wordMap.get(i).keySet()) {
				
		// 	}
		}

		
	}
}




