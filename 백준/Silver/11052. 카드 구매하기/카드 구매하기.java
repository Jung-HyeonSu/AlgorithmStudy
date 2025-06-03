import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        int[] max = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i+1; j++) {
                max[i] = Math.max(max[i], max[i-j] + arr[j]);
            }
        }
        System.out.println(max[N]);
    }
}
