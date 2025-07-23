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
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); 

        arr = new int[M];
        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i++) {
            arr[depth] = num[i];
            dfs(i + 1, depth + 1);
        }
    }
}
