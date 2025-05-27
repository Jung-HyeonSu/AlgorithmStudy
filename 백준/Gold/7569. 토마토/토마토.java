import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][][] arr;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int result = 0;
    public static class Tomato{
        int x;
        int y;
        int z;
        int day;
        public Tomato(int x, int y, int z, int day){
            this.x=x;
            this.y=y;
            this.z=z;
            this.day=day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[M][N][H];
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int m=0; m<M; m++){
                    arr[m][n][h] = Integer.parseInt(st.nextToken());
                }
            }
        }
        Queue<Tomato> q = new LinkedList<Tomato>();
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(arr[m][n][h] == 1){
                        q.add(new Tomato(m,n,h, 0));
                    }
                }
            }
        }

        bfs(q);

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(arr[m][n][h] == 0){
                        result = -1;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs(Queue<Tomato> q){
        while (!q.isEmpty()){
            Tomato t = q.poll();
            for(int i=0; i<6; i++){
                int new_x = t.x + dx[i];
                int new_y = t.y + dy[i];
                int new_z = t.z + dz[i];

                if(new_x < 0 || new_y < 0 || new_z < 0 || new_x >= M || new_y >= N || new_z >= H){
                    continue;
                }
                if(arr[new_x][new_y][new_z] == 0){
                    arr[new_x][new_y][new_z] = 1;
                    result = t.day+1;
                    q.add(new Tomato(new_x, new_y, new_z, t.day+1));
                }
            }
        }
    }
}
