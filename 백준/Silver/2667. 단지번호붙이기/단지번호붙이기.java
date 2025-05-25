import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == 0 && arr[i][j] != 0){
                    result++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);

        int[] counts = new int[result + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != 0) {
                    counts[visited[i][j]]++;
                }
            }
        }

        Arrays.sort(counts, 1, result + 1);
        for (int i = 1; i <= result; i++) {
            System.out.println(counts[i]); // 각 단지 내 집의 수 출력
        }
    }

    public static void dfs(int x, int y) { //깊이 우선 탐색
        visited[x][y] = result;
        for(int i=0; i<4; i++){
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            if(new_x < 0 || new_y < 0 || new_x >= N || new_y >= N){
                continue;
            }

            if(visited[new_x][new_y] == 0 && arr[new_x][new_y] == 1){
                dfs(new_x, new_y);
            }
        }
    }
}
