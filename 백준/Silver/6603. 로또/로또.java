import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0){
                break;
            }

            arr = new int[K];
            for(int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];

            Arrays.sort(arr);

            dfs(0, 0);
            sb.append("\n");
        }
        System.out.print(sb.toString());

    }

    public static void dfs(int start, int depth){
        if(depth == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
