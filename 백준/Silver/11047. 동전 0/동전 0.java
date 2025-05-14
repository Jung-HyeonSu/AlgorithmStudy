import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        int count = 0;
        int num = n-1;
        for(int i=0; i<n; i++){
            money[i] = Integer.parseInt(br.readLine());
        }
        
        while(k != 0){
            if(money[num] <= k ){
                k -= money[num];
                count++;
            }
            else{
                num--;
            }
        }

        System.out.println(count);
    }
}