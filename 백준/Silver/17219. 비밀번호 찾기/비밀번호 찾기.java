import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

       HashMap<String, String> map = new HashMap<>();
        String[][] arr = new String[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for(int i=0; i<M; i++){
            String str = br.readLine();
            sb.append(map.get(str)).append("\n");
        }
		

		System.out.print(sb);
    }
}