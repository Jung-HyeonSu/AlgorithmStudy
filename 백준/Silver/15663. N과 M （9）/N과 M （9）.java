import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[] arr, num;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		num = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if(M == depth){
			for(int i=0; i<arr.length; i++){
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int before = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && num[i] != before) {
                visited[i] = true;
                arr[depth] = num[i];
                before = num[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
	}
}