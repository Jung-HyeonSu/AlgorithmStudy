import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] picture;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        picture = new int[N][M];
        visited = new boolean[N][M];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
                
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && picture[i][j] == 1){
                    count++;
                    bfs(i, j);
                    result.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        System.out.println(result.isEmpty() ? 0 : result.get(result.size() - 1));
    }

    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && picture[nx][ny] == 1){
                    count++;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        
    }
}
