import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            // 스택이 비어있거나 i가 직전에 담긴 값과 다를 경우 스택에 i 넣기
            if (stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}