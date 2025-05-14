import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] human = new int[n];
        int sum = 0;
        int accumulate = 0;

        for(int i=0; i<n; i++){
            human[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(human[j]<human[i]) {
                    int temp = 0;
                    temp = human[j];
                    human[j] = human[i];
                    human[i] = temp;
                }
            }
        }

        for(int i=0; i<n; i++) {
            accumulate = accumulate + human[i];
            sum += accumulate;
        }

        System.out.println(sum);
    }
}