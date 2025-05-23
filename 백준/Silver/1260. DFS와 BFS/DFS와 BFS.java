import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(V);
        visited = new boolean[N+1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start) { //깊이 우선 탐색
        visited[start] = true;
        sb.append(start);
        sb.append(" ");
        for(int i=1; i<N+1; i++){
            if(arr[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start) { //너비 우선 탐색
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start);
            sb.append(" ");
            for(int i=1; i<N+1; i++) {
                if(arr[start][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
