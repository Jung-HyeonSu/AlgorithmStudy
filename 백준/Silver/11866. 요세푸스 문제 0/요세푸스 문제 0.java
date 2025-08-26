import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!q.isEmpty()){
            for(int i=1; i<K; i++){
                q.add(q.poll());
            }
            sb.append(q.poll());
            if(!q.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
