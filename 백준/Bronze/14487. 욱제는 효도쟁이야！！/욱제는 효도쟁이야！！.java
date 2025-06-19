import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cost = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            count += cost[i];
        }
        Arrays.sort(cost);
        count -= cost[n - 1];

        System.out.println(count);
    }
}