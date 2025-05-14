import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[][] meeting= new int[n][2];
        int count = 0;
        int lastEndTime = 0;

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (a, b)->{
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });


        for(int i=0; i<n; i++){
            if(meeting[i][0] >= lastEndTime){
                count++;
                lastEndTime = meeting[i][1];
            }
        }

        System.out.print(count);
    }
}