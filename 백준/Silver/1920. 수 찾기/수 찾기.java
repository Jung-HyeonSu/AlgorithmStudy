import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);

        for (int i = 0; i < M; i++) {
            int target = arrB[i];
            int left = 0;
            int right = N - 1;
            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arrA[mid] == target) {
                    found = true;
                    break;
                } else if (arrA[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (found) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.print(sb);
    }
}
