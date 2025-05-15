import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int loc = Integer.parseInt(st.nextToken());
            if (loc < 0) {
                negative.add(Math.abs(loc)); // 음수 위치를 절대값으로 저장
            } else {
                positive.add(loc);
            }
        }

        // 내림차순 정렬 (가장 먼 거리부터 처리)
        Collections.sort(negative, Collections.reverseOrder());
        Collections.sort(positive, Collections.reverseOrder());

        int maxDistance = 0;
        int totalDistance = 0;

        // 음수 처리
        for (int i = 0; i < negative.size(); i += m) {
            totalDistance += negative.get(i) * 2; // 왕복 거리
            maxDistance = Math.max(maxDistance, negative.get(i));
        }

        // 양수 처리
        for (int i = 0; i < positive.size(); i += m) {
            totalDistance += positive.get(i) * 2; // 왕복 거리
            maxDistance = Math.max(maxDistance, positive.get(i));
        }

        // 최종 거리 계산 (마지막 가장 먼 거리만 편도로)
        totalDistance -= maxDistance;

        System.out.println(totalDistance);
    }
}
