import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] fibonacci = new long[91];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i=2; i<=N; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
		
        System.out.println(fibonacci[N]);
	}
}