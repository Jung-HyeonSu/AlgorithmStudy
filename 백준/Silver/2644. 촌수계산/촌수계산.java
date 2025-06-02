import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B, M;
    static boolean[][] relation;
    static boolean[] visited;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        relation = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation[x][y] = relation[y][x] = true;
        }

        dfs(A, B, 0);
        System.out.println(result);
    }

    public static void dfs(int current, int target, int depth) {
        if (current == target) {
            result = depth;
            return;
        }

        visited[current] = true;
        for (int i = 1; i <= N; i++) {
            if (relation[current][i] && !visited[i]) {
                dfs(i, target, depth + 1);
                if (result != -1) return;
            }
        }
        visited[current] = false;
    }
}
