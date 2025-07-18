import java.io.*;
import java.util.*;
 
public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dfs(1, 0 ,new int[M]);
		System.out.print(sb.toString());
	}

	static void dfs(int start, int depth, int[] arr) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1, arr);
        }
    }
}