import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        int maxHeight = 0;
        int maxSafe = 0;
		for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }
        for(int h=0; h<=maxHeight; h++){
            visited = new boolean[N][N];
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j]>h && !visited[i][j]){
                        count++;
                        bfs(i, j, h);
                    }
                }      
            }
            maxSafe = Math.max(count, maxSafe);
        }
        System.out.println(maxSafe);
    }

    public static void bfs(int x, int y, int height){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];

            for(int i=0; i<4; i++){
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];

                if(new_x >= 0 && new_y >= 0 && new_x < N && new_y < N
                && !visited[new_x][new_y] && arr[new_x][new_y] > height){
                    visited[new_x][new_y] = true;
                    q.add(new int[] {new_x, new_y});
                }
            }
        }
    }
}