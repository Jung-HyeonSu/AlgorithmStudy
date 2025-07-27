import java.io.*;
import java.util.*;

public class Main {
    static long A, B;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
   
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                long tmp = queue.poll();
                if(tmp==B)
                    return ++count;

                if(tmp*2<=B) queue.add(tmp*2);
                if(tmp*10+1<=B) queue.add(tmp*10+1);
            }
            count++;
        }

        return -1;
    }
}
