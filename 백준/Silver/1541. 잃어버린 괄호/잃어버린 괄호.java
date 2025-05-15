import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strSplitMinus = str.split("-");
        int[] strSplitMinusSum = new int[strSplitMinus.length];
        int result = 0;
        for(int i=0; i< strSplitMinus.length; i++){
            String[] strSplitPlus = strSplitMinus[i].split("\\+");
            for(int j=0; j< strSplitPlus.length; j++){
                strSplitMinusSum[i] += Integer.valueOf(strSplitPlus[j]);
            }
        }

        for(int i=0; i< strSplitMinusSum.length; i++){
            if(i==0){
                result = strSplitMinusSum[i];
            }
            else{
                result -= strSplitMinusSum[i];
            }
        }
        System.out.print(result);
    }
}
