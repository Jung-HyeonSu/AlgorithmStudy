import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = 1;
        dp[0] = arr[0];
        for(int i=1; i<=N; i++){
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                } 
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
