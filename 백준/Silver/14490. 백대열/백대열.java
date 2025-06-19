import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] a;
    static Integer[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),":");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(n/GCD(n,m)+":"+m/GCD(n,m));
    }

    public static int GCD(int n,int m){
        while(m>0){
            int temp = n;
            n = m;
            m = temp%m;
        }return n;
    }
}