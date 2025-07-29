import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] dp = new long[46];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 46; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        for(int i=0; i<n; i++){
            System.out.println(dp[arr[i]]);
        }
    }
}