import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int sheep;
    static int wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new String[R][C];
            visited = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = String.valueOf(str.charAt(j));
                }
            }

            int sheep = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j].equals("#") && !visited[i][j]) {
                        sheep++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(sheep);
        }
        
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            for (int i = 0; i < 4; i++) {
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];
                if (new_x >= 0 && new_y >= 0 && new_x < R && new_y < C && !visited[new_x][new_y]
                        && map[new_x][new_y].equals("#")) {
                    visited[new_x][new_y] = true;
                    queue.add(new int[] { new_x, new_y });
                }
            }
        }
    }
}