import java.io.*;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static char[] chars;
    static boolean[] visited;
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            chars = line.toCharArray();
            int n = chars.length;
            visited = new boolean[n];
            result = new char[n];

            sb.append("Case # ").append(tc).append(":");
            sb.append("\n");
            dfs(0);
        }

        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        if (depth == chars.length) {
            sb.append(new String(result)).append('\n');
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = chars[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
