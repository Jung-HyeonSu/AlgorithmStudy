import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t];
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
        }

        for(int i=0; i <t; i++){
            n[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i <t; i++){
            System.out.println(dp[n[i]]);
        }
    }
}
