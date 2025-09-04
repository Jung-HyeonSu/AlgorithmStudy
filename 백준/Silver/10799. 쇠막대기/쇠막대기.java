import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        String s = bf.readLine(); //String
        Stack<Character> stack=new Stack<Character>();

        int result=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    stack.pop();
                    result+=stack.size();
                }
                else if(s.charAt(i-1)!='('){
                    result+=1;
                    stack.pop();

                }
            }
        }

        System.out.print(result);
    }

}