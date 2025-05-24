import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(!visited[i][j]){
                    result++;
                    dfs(i,j);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(result);
        str.append(" ");
        result = 0;
        visited = new boolean[N+1][N+1];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 'G'){
                    arr[i][j] = 'R';
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                if(!visited[i][j]){
                    result++;
                    dfs(i,j);
                }
            }
        }
        str.append(result);

        System.out.println(str);
    }

    public static void dfs(int x, int y) { //깊이 우선 탐색
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            if(new_x < 0 || new_y < 0 || new_x > N || new_y > N){
                continue;
            }

            if(arr[new_x][new_y] == arr[x][y] && !visited[new_x][new_y]){
                dfs(new_x, new_y);
            }
        }
    }
}
