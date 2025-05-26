import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] visited;
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x=x1;x<x2;x++) {
                for(int y=y1;y<y2;y++) {
                    arr[y][x] = 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] != 1 && visited[i][j] == 0){
                    result++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(result);

        int[] individualCount = new int[result+1];
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] != 0){
                    individualCount[visited[i][j]]++;
                }
            }
        }
        Arrays.sort(individualCount);
        for(int i=1; i<result+1; i++){
            System.out.print(individualCount[i] + " ");
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = result;
        for(int i=0; i<4; i++){
            int new_x = x-dx[i];
            int new_y = y-dy[i];

            if(new_x < 0 || new_y < 0 || new_x >= N || new_y >= M){
                continue;
            }

            if(visited[new_x][new_y] != 0 || arr[new_x][new_y] == 1){
                continue;
            }
            dfs(new_x, new_y);
        }
    }
}
