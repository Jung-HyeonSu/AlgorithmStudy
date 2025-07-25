import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); 

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = num[i];
            dfs(depth + 1);
        }
    }

}
