import java.util.*;
class Solution {
    public int[] solution(int[] answers) { 
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] temp = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) temp[0]++;
            if (two[i % two.length] == answers[i]) temp[1]++;
            if (three[i % three.length] == answers[i]) temp[2]++;
        }
        
        int max = Math.max(temp[0], Math.max(temp[1], temp[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(max == temp[0]) list.add(1);
        if(max == temp[1]) list.add(2);
        if(max == temp[2]) list.add(3);

        int [] answer = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}