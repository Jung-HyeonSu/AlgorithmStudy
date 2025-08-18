import java.io.*;
import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        for(int i=0; i<name.length(); i++){
            char start = 'A';
            char now = name.charAt(i);
            answer += Math.min(now - 'A', 'Z' - now + 1);
        }
        
        int move = len - 1;
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }
        return answer + move;
    }
}