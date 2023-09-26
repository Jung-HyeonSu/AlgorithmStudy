
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,b,result1, result2, result3;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        result1 = a *(((b-((b/100)*100)))-(((b-((b/100)*100)))/10)*10);
        result2 = a * ((b-((b/100)*100))/10);
        result3 = a *(b/100);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(a*b);
    }
}