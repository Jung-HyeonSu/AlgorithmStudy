import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(q.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(q.poll());
                }
            }
            else{
                q.add(input);
            }
        }
    }
}