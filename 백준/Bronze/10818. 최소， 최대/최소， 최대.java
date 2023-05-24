import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 정수의 개수 입력
        int[] numbers = new int[N];

        // N개의 정수 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        int min = Integer.MAX_VALUE; // 최솟값 초기화
        int max = Integer.MIN_VALUE; // 최댓값 초기화

        // 최솟값과 최댓값 구하기
        for (int i = 0; i < N; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println(min + " " + max);
    }
}