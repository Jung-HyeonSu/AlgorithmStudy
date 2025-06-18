import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for(int i=0; i<nums.length; i++){
            if(i == 0 || nums[i-1] != nums[i]){
                answer++;
            }
        }
        if(answer<nums.length/2){
            return answer;
        }
        else{
            return nums.length/2;
        }
    }
}