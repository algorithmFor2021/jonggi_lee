import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
class P5052 {
    static int N;
    static String ans;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\eclipse\\workspace\\Study\\WebContent\\P5052.txt"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++) {
            int t = Integer.parseInt(br.readLine());
            String[] arr = new String[t];
            ans = "YES";      

            for(int j=0;j<t;j++) {
                arr[j]=br.readLine();
            }

            Arrays.sort(arr);

            for(int j=1;j<t;j++) {
                if(arr[j].startsWith(arr[j-1])) {
                    ans = "NO";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
