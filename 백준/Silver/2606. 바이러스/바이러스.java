import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        visited = new boolean[N+1];
        System.out.println(result);
    }

    public static void dfs(int start) { //깊이 우선 탐색
        visited[start] = true;
        for(int i=1; i<N+1; i++){
            if(arr[start][i] == 1 && !visited[i]){
                result++;
                dfs(i);
            }
        }
    }
}
