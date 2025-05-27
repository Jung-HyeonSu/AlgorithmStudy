import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static boolean[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = true;
        }
        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int start){
        visited[start] = true;
        for(int i=1; i<N+1; i++){
            if(arr[start][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}
