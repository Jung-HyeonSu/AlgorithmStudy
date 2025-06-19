import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        if(num % 7 == 0 || num % 7 == 2) {
            System.out.println("CY");
        }else {	
            System.out.println("SK");
        }
    }
}