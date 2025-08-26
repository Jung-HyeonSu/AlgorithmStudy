import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            for(int i=0; i<N; i++){
                q.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                boolean hasHigher = false;

                for(int[] doc : q){
                    if(doc[1] > cur[1]){
                        hasHigher = true;
                        break;
                    }
                }

                if(hasHigher){
                    q.add(cur); // 중요도 더 높은 문서 있으면 뒤로
                } else {
                    count++;
                    if(cur[0] == M){ // 궁금한 문서라면
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
