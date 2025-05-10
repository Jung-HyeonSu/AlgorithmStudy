import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        String arr[] = new String[input];
        Boolean decreasingCheck = true;
        Boolean increasingCheck = true;

        for(int i=0; i<input; i++){
            arr[i] = br.readLine();
            if(i != 0){
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    increasingCheck = false;
                }
                if (arr[i - 1].compareTo(arr[i]) < 0) {
                    decreasingCheck = false;
                }
            }
        }

        if(decreasingCheck && !increasingCheck){
            System.out.print("DECREASING");
        }
        else if(!decreasingCheck && increasingCheck){
            System.out.print("INCREASING");
        }
        else{
            System.out.print("NEITHER");
        }
    }
}
