import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		int[] arr = new int[20];
		int t;
		for(int i=0; i<P; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			for(int j=0; j<20; j++){
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for (int j = 1; j < 20; j++) {
                int key = arr[j];
                int k = j - 1;
                while (k >= 0 && arr[k] > key) {
                    arr[k + 1] = arr[k];
                    k--;
                    cnt++;
                }
                arr[k + 1] = key;
            }
			

			System.out.println(t + " " + cnt);
		}
	}
}