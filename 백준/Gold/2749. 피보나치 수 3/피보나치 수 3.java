import java.io.*;
import java.util.*;

public class Main {
    //피사노 주기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long index = n % 1500000;
        long[] dp = new long[(int)index + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<= index; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
        }
        System.out.println(dp[(int)index]);
    }
}