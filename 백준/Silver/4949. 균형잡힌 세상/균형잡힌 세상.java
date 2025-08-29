import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean balanced = true;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
                else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
                else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (balanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
