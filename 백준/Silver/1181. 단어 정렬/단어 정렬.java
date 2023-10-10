import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        String uniqueArr[] = new String[n];
        int uniqueCount = 0;

        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, Comparator.comparing(String::length).thenComparing(String::compareTo));
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || !arr[i].equals(arr[i - 1])) {
                uniqueArr[uniqueCount++] = arr[i];
            }
        }
        for(int i=0;i<uniqueCount;i++){
            System.out.println(uniqueArr[i]);
        }
    }
}
