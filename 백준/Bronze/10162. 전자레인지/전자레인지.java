import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

		if (N % 10 != 0) {
            System.out.println(-1);
            return;
        }

        int A = N / 300;
        N %= 300;

        int B = N / 60;
        N %= 60;

        int C = N / 10;

		System.out.println(A + " " + B + " " + C);
    }
}
