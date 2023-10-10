import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        String[] list = number.split("");
        int[] list2 = new int[list.length];

        for(int i = 0;i<list.length;i++){
            list2[i] = Integer.parseInt(list[i]);
        }
        Arrays.sort(list2);
        for(int i = list2.length-1;i>=0;i--){
            System.out.print(list2[i]);
        }
        System.out.println();
    }
}
