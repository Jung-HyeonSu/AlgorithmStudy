import java.io.*;
import java.util.*;

public class Main {
    static int[] M;
    static int[] N;
    static int[] K;
    static boolean[][][] cabbage;
    static int[] result;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        M = new int[T];
        N = new int[T];
        K = new int[T];
        result = new int[T];
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M[t] = Integer.parseInt(st.nextToken());
            N[t] = Integer.parseInt(st.nextToken());
            K[t] = Integer.parseInt(st.nextToken());

            cabbage= new boolean[T][M[t]][N[t]];
            for(int i=0; i<K[t]; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[t][x][y] = true;
            }

            for(int i=0; i<M[t]; i++){
                for(int j=0; j<N[t]; j++){
                    if(cabbage[t][i][j]){
                        result[t]++;
                        dfs(i,j,t);
                    }
                }
            }
        }

        for(int t=0; t<T; t++){
            System.out.println(result[t]);
        }
    }

    public static void dfs(int x, int y, int t){
        cabbage[t][x][y] = false;
        for(int i=0; i<4; i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];

            if(new_x < 0 || new_y <0 || new_x >= M[t] || new_y >= N[t]){
                continue;
            }

            if(cabbage[t][new_x][new_y]){
                dfs(new_x, new_y, t);
            }
        }
    }
}
