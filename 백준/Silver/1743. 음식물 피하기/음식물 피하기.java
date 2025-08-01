import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하
    static int N, M, K;
    static String[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = "#";
        }

        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(map[i][j] != null && !visited[i][j]){
                    count++;
                    bfs(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
    }

    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0];
            int now_y = now[1];
            for(int i=0; i<4; i++){
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];

                if(new_x >= 1 && new_y >= 1 && new_x < N+1 && new_y < M+1 && !visited[new_x][new_y] && map[new_x][new_y] != null){
                    visited[new_x][new_y] = true;
                    queue.add(new int[] {new_x, new_y});
                    count++;
                }
            }
        }
    }
}