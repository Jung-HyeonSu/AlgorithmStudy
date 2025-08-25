import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][2];

        dp[1][0] = 0; // 길이 1, 끝이 0인 건 없음
        dp[1][1] = 1; // "1" 하나만 가능

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1]; // 끝이 0, 전 단계 끝이 0 or 1
            dp[i][1] = dp[i-1][0];              // 끝이 1, 전 단계 끝이 0만 가능
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
