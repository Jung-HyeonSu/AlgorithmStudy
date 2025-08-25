import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dpA = new int[N+1];
		int[] dpB = new int[N+1];
		dpA[1] = 0;
		dpB[1] = 1;
		for(int i=2; i<=N; i++){
			dpA[i] = dpB[i-1];
			dpB[i] = dpA[i-1] + dpB[i-1];
		} 

		System.out.println(dpA[N] + " " + dpB[N]);
	}
}