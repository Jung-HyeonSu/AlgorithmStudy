import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int open = 0, unmatched = 0;

        for (char c : line.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--; // 짝이 맞는 괄호 제거
                } else {
                    unmatched++; // 여는 괄호 없이 닫는 괄호가 나옴
                }
            }
        }

        System.out.println(open + unmatched);
    }
}