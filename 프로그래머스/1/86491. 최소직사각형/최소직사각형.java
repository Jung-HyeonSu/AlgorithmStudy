class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxLength = 0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][1] > sizes[i][0]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if(sizes[i][0] > maxWidth){
                maxWidth = sizes[i][0];
            }
            if(sizes[i][1] > maxLength){
                maxLength = sizes[i][1];
            }
        }
        answer = maxWidth * maxLength;
        return answer;
    }
}