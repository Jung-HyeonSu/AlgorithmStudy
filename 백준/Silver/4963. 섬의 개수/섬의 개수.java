import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static int w, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			int result = 0;
			if (w == 0 && h == 0) {
				return;
			}

			map = new int[w][h];
			visited = new boolean[w][h];
			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < h; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if(map[i][j] == 1 && !visited[i][j]){
						result++;
						bfs(i, j);
					}
				}
			}

			System.out.println(result);
		}
	}

	public static void bfs(int x, int y){
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];

			for(int i=0; i<8; i++){
				int new_x = now_x + dx[i];
				int new_y = now_y + dy[i];
				if(new_x >= 0 && new_y >= 0 && new_x < w && new_y < h 
					&& map[new_x][new_y] == 1 && !visited[new_x][new_y]){
					visited[new_x][new_y] = true;
					q.add(new int[] {new_x, new_y});
				}
			}

		}
	}
}