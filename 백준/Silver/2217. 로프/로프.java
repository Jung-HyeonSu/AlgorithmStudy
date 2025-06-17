import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];
        for(int i=0; i<N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());  //내림차순으로 정렬하기
        int total = 0;
        for (int i = 0; i < N; i++) {
            total = Math.max(total, rope[i] * (i+1));
        }
        System.out.print(total);
    }
}