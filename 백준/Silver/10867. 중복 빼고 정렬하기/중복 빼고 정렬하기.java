import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];

        for(int i=0; i<N; i++){
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        String prev = null;
        for (String s : arr) {
            if (!s.equals(prev)) {
                sb.append(s).append(' ');
                prev = s;
            }
        }

        System.out.print(sb);
    }

}
