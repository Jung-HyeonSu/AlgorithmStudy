import java.io.*;
import java.util.*;
 
public class Main {
	//예외 조건: A[i+1] > A[i+2] 일 땐 2개 묶음을 먼저 처리해야 비용이 더 낮음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] A = new int[N+3];
		int totalCost = 0;
		for(int i=0; i<N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<N; i++){
			if(A[i+1] > A[i+2]){
				int count = Math.min(A[i], A[i+1] - A[i+2]);
				A[i] -= count;
				A[i+1] -= count;
				totalCost += count * 5;

				int count2 = Math.min(A[i], Math.min(A[i+1], A[i+2]));
				A[i] -= count2;
				A[i+1] -= count2;
				A[i+2] -= count2;
				totalCost += count2 * 7;
			}
			else {
				int count = Math.min(A[i], Math.min(A[i+1], A[i+2]));
				A[i] -= count;
				A[i+1] -= count;
				A[i+2] -= count;
				totalCost += count * 7;

				int count2 = Math.min(A[i], A[i+1]);
				A[i] -= count2;
				A[i+1] -= count2;
				totalCost += count2 * 5;
			}
			totalCost += A[i] * 3;
			A[i] = 0;
		}

		System.out.println(totalCost);
	}
}