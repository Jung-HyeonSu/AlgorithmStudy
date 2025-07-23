import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        visited = new boolean[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); 

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int start, int depth){
        if(depth == M){
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i<N; i++){
                arr[depth] = num[i];
                dfs(i, depth + 1);
            
        }
    }

}
