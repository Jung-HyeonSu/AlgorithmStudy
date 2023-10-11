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
        boolean check = false;
        int count = 0;
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }

        for(int i=0;i<n;i++){
            for(int j =0;j<arr[i].length();j++){
                for(int k=j+2;k<arr[i].length();k++){
                    if((arr[i].charAt(j))==(arr[i].charAt(k))){
                        if((arr[i].charAt(k-1))!=(arr[i].charAt(k))){
                            check = true;
                        }
                    }
                }
            }
            if(check == false){
                count++;
            }
            else{
                check = false;
            }
        }
        System.out.println(count);
    }
}
