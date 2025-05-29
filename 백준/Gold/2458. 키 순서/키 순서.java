import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) -1;
            int y = Integer.parseInt(st.nextToken()) -1;
            visited[x][y] = true;
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][k] && visited[k][j]) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[] cnt = new int[N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] || visited[j][i]) {
                    cnt[i] ++;
                }
            }
        }

        int res =0;
        for(int num : cnt) {
            if(num == N-1) res++;
        }
        System.out.println(res);
    }

}
