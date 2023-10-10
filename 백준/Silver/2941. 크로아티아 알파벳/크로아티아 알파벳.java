import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        String[] arr = test.split("");
        int count = 0;
        for(int i = 0;i<arr.length;i++) {
            count++;
            if(i!=arr.length-1){
                if(arr[i].equals("c")){
                    if(arr[i+1].equals("=")||arr[i+1].equals("-")){
                        i++;
                    }
                }
                if(arr[i].equals("d")){
                    if(arr[i+1].equals("z")){
                        if(i!=arr.length-2){
                            if(arr[i+2].equals("=")){
                                if(i+2 != arr.length-1){
                                    i++;
                                    i++;
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                    if(arr[i+1].equals("-")){
                        i++;
                    }
                }
                if(arr[i].equals("l")){
                    if(arr[i+1].equals("j")){
                        i++;
                    }
                }
                if(arr[i].equals("n")){
                    if(arr[i+1].equals("j")){
                        i++;
                    }
                }
                if(arr[i].equals("s")){
                    if(arr[i+1].equals("=")){
                        i++;
                    }
                }
                if(arr[i].equals("z")){
                    if(arr[i+1].equals("=")){
                        i++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
