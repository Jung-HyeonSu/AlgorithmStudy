import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for(int i=1; i<arr.length; i++){
            max = Math.max(Integer.parseInt(arr[i]), max);
            min = Math.min(Integer.parseInt(arr[i]), min);
        }
        return min + " " + max;
    }
}