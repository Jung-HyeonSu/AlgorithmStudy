import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static int count_1=0;
    public static int dp_count=0;
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        fib(n);
        fibonacci(n);
        System.out.println(count_1 + " " + dp_count);
    }

    public static int fib(int n){
        if(n==1 || n==2)
        {
            count_1++;
            return 1;
        }
        else
        {
            return fib(n-2) + fib(n-1);
        }
    }

    public static int fibonacci(int n){
        dp[1] = dp[2] = 1;
        for(int i=3; i<=n; i++)
        {
            dp[i] = dp[i-2] + dp[i-1];
            dp_count++;
        }
        return dp[n];
    }
}