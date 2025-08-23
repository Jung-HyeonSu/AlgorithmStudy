import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N];
			int[][] dp = new int[2][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];

			if (N > 1) {
				dp[0][1] = sticker[0][1] + dp[1][0];
				dp[1][1] = sticker[1][1] + dp[0][0];
			}
			for (int j = 2; j < N; j++) {
				dp[0][j] = sticker[0][j] + Math.max(dp[1][j - 1], dp[1][j - 2]);
				dp[1][j] = sticker[1][j] + Math.max(dp[0][j - 1], dp[0][j - 2]);
			}

			int result = Math.max(dp[0][N - 1], dp[1][N - 1]);
			System.out.println(result);
		}
	}
}