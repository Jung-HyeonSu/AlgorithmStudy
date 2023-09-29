import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        Double[] arr = new Double[t];

        double max = 0;
        double avg = 0;
        for(int i=0;i<t;i++) {
            arr[i] = sc.nextDouble();
            if(max<arr[i]){
                max = arr[i];
            }
        }

        for(int i=0;i<t;i++) {
            arr[i] = arr[i]/max*100;
            avg += arr[i];
        }
        System.out.println(avg/t);
    }
}
