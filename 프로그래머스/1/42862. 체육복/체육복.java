import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        int[] students = new int[n];
        Arrays.fill(students, 1);
        for(int i: lost){
            students[i-1]--;
        }
        for(int i: reserve){
            students[i-1]++;
        }
        
        for(int i=0; i< n; i++){
            if(students[i] == 0){
                if(i > 0 && students[i-1] > 1){
                    students[i-1]--;
                    students[i]++;
                }
                else if(i < n-1 &&students[i+1] > 1){
                    students[i+1]--;
                    students[i]++;
                }
            }
            if(students[i] >= 1) count++;
        }
        return count;
    }
}