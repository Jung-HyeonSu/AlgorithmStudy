import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하
    static int N, M;
    static String[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int x = -1;
        int y = -1;

        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = String.valueOf(str.charAt(j));
                if(map[i][j].equals("I")){
                    x = i;
                    y = j;
                }
            }
        }
        count = 0;
        bfs(x, y);
        if(count == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(count);
        }
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

                if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < M && !visited[new_x][new_y] && !map[new_x][new_y].equals("X")){
                    visited[new_x][new_y] = true;
                    queue.add(new int[]{new_x, new_y});
                    if(map[new_x][new_y].equals("P")){
                        count++;
                    }
                }
            }
        }
    }
}