import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arrA);

        for(int i=0; i<M; i++){
            int L = 0;
            int R = N - 1;
            boolean found = false;
            while(L <= R){
                int mid = (L+R) / 2;

                if(arrA[mid] == arrB[i]){
                    found = true;
                    break;
                }
                else if(arrA[mid] < arrB[i]){
                    L = mid + 1; 
                }
                else{
                    R = mid - 1; 
                }
            }
            if(found) {
                sb.append(1).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }
        }
        System.out.print(sb);
    }
}