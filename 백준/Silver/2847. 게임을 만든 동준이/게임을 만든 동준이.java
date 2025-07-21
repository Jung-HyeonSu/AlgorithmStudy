import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] point = new int[N];
        int count = 0;
        for(int i=0; i<N; i++){
            point[i] = Integer.parseInt(br.readLine());
        }

        for(int i= N-1; i>=0; i--){
            if(i != N-1){
                if(point[i] >= point[i+1]){
                    count += point[i] - point[i+1] + 1;
                    point[i] = point[i] - (point[i] - point[i+1] + 1);
                }
            }
        }
        System.out.println(count);
    }
}