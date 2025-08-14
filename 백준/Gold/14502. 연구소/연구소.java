import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int[][] map;
	static List<int[]> virusList = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int maxSafe = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					virusList.add(new int[] { i, j });
				}
			}
		}

		dfs(0);
		System.out.println(maxSafe);
	}

	// 벽 세우기
	public static void dfs(int count) {
		if (count == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(count + 1);
					map[i][j] = 0; // 백트래킹
				}
			}
		}
	}

	public static void bfs() {
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		Queue<int[]> q = new LinkedList<>();
		for (int[] v : virusList) {
			q.offer(v);
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 2;
						q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		countSafe(copyMap);
	}

	public static void countSafe(int[][] map) {
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					safe++;
			}
		}
		maxSafe = Math.max(maxSafe, safe);
	}
}