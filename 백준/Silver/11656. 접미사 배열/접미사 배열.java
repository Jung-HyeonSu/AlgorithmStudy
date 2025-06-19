import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String[] str = new String[S.length()];
        for(int i=0; i<S.length(); i++){
            str[i] = S.substring(i);
        }
        Arrays.sort(str);
        for (String s : str) {
            System.out.println(s);
        }
    }
}
