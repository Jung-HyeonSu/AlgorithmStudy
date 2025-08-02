import java.io.*;
import java.util.*;

public class Main {
    static int T, I;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int[] start = new int[2];
            int[] finish = new int[2];
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            finish[0] = Integer.parseInt(st.nextToken());
            finish[1] = Integer.parseInt(st.nextToken());

            bfs(start[0], start[1]);

            System.out.println(map[finish[0]][finish[1]]);
        }
    }

    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int now_x = now[0];
            int now_y = now[1];

            for(int i=0; i<8; i++){
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];

                if(new_x >= 0 && new_y >= 0 && new_x < I && new_y < I && !visited[new_x][new_y]){
                    visited[new_x][new_y] = true;
                    map[new_x][new_y] = map[now_x][now_y] + 1;
                    queue.add(new int[] {new_x, new_y});
                }
            }
        }
    }
}
