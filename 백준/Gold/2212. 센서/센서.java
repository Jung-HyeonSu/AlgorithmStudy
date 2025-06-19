import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] a;
    static Integer[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        a = new int[N];
        b = new Integer[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for (int i = 0; i < N - 1; i++) {
            b[i] = a[i + 1] - a[i];
        }
        Arrays.sort(b);
        int result = 0;
        for (int i = 0; i < N - K; i++){
            result += b[i];
        }
        System.out.println(result);

    }
}