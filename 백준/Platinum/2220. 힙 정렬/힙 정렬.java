import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 트리에서 노드 i의 부모 노드 인덱스는 i/2라는 것을 활용.
        // 루트 노드에 계속 최댓값을 넣어주고 나머지 원소를 하나씩 뒤로 미룬다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];


        for (int i=1; i<n; i++) {
            for (int j=i; j>1; j/=2) {
                arr[j] = arr[j/2];
            }
            arr[1] = i+1;
        }

        arr[n] = 1;
        for (int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}