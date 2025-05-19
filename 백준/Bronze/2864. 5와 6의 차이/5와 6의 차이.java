import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        String maxA = "";
        String maxB = "";
        String minA = "";
        String minB = "";

        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) == '5' || a.charAt(i) == '6'){
                maxA += "6";
                minA += "5";
            }else{
                maxA += a.charAt(i);
                minA += a.charAt(i);
            }
        }

        for(int i=0; i<b.length(); i++){
            if(b.charAt(i) == '5' || b.charAt(i) == '6'){
                maxB += "6";
                minB += "5";
            }else{
                maxB += b.charAt(i);
                minB += b.charAt(i);
            }
        }

        int min = Integer.parseInt(minA) + Integer.parseInt(minB);
        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(min + " " + max);
    }
}
