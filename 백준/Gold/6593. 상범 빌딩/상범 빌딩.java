import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1, 0, 0}; // 동서
    static int[] dy = {-1, 1, 0, 0, 0, 0}; // 남북
    static int[] dz = {0, 0, 0, 0, -1, 1}; // 상하
    static int L, R, C;
    static String[][][] map;
    static boolean[][][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String line = br.readLine();
            if (line == null || line.length() < C) {
                line = br.readLine();
            }
            StringTokenizer st = new StringTokenizer(line);

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0){
                return;
            }

            map = new String[L][R][C];
            visited = new boolean[L][R][C];
            int[] start = new int[3];
            count = 0;
            for(int l=0; l<L; l++){
                for(int r=0; r<R; r++){
                    String str = br.readLine();
                    if (str == null || str.length() < C) {
                        str = br.readLine();
                    }
                    for(int c=0; c<C; c++){
                        map[l][r][c] = String.valueOf(str.charAt(c));
                        if(map[l][r][c].equals("S")){
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        }
                    }
                }
            }
            int result = bfs(start[0], start[1], start[2]);

            if(result == 0){
                System.out.println("Trapped!");
            }
            else{
                System.out.println("Escaped in " + result + " minute(s).");
            }
        } 
    }

    public static int bfs(int l, int r, int c){
        visited[l][r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{l, r, c, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_L = now[0];
            int now_R = now[1];
            int now_C = now[2];
            int time = now[3];

            if (map[now_L][now_R][now_C].equals("E")) {
                return time;
            }

            for(int i=0; i<6; i++){
                int new_L = now_L + dz[i];
                int new_R = now_R + dy[i];
                int new_C = now_C + dx[i];

                if(new_L >= 0 && new_R >= 0 && new_C >= 0 && new_L < L && new_R < R && new_C < C 
                && !visited[new_L][new_R][new_C] && !map[new_L][new_R][new_C].equals("#")){
                    visited[new_L][new_R][new_C] = true;
                    queue.add(new int[]{new_L, new_R, new_C, time + 1});
                }
            }
        }
        return 0;
    }
}