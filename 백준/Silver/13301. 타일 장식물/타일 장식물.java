import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[81];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.out.println(dp[N] * 2 + dp[N-1] * 2);
    }
}