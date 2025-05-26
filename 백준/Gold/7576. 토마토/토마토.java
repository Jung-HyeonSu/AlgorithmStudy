import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] tomatoes;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int days = 0;

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Tomato> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomatoes[i][j] == 1){
                    q.add(new Tomato(i,j,0));
                }
            }
        }

        bfs(q);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomatoes[i][j] == 0){
                    days = -1;
                }
            }
        }

        System.out.println(days);
    }

    public static void bfs(Queue<Tomato> q){ //너비 우선 탐색
        while (!q.isEmpty()){
            Tomato t = q.poll();
            for(int i=0; i<4; i++){
                int new_x = t.x+dx[i];
                int new_y = t.y+dy[i];

                if(new_x < 0 || new_y < 0 || new_x >= N || new_y >= M){
                    continue;
                }
                if(tomatoes[new_x][new_y] == 0){
                    tomatoes[new_x][new_y] = 1;
                    days = t.day+1;
                    q.add(new Tomato(new_x, new_y, t.day+1));
                }
            }
        }
    }
}
