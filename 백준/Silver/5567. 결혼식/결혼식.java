import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static boolean[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=M; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = true;
		}
		cnt = 0;
		bfs(1);
		System.out.println(cnt);
	}

	public static void bfs(int start){
		visited[start] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start, 0});
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int now_start = now[0];
			int now_count = now[1];
			for(int i=2; i<=N; i++){
				if(!visited[i] && arr[now_start][i] && now_count < 2){
					visited[i] = true;
					queue.add(new int[] {i, now_count+1});
					cnt++;
				}

			}
		}
	}
}