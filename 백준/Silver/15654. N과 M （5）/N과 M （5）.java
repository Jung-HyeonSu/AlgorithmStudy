import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] arr;
    static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        arr = new int[M];
        visited = new boolean[N];
        dfs(N, M, 0);

		
        System.out.println(sb);
	}

    static void dfs(int N, int M, int depth){
        if(depth == M){
            for(int i:arr){
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = num[i];
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}