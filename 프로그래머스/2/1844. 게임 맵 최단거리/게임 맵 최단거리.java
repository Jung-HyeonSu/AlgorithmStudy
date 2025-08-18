import java.io.*;
import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1}; //좌우
    static int[] dy = {-1, 1, 0, 0}; //상하
    static boolean[][] visited;
    static int answer = -1;
    static int row;
    static int col;
    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        visited = new boolean[row][col];
        bfs(0, 0, maps);
        return answer;
    }
    
    public void bfs(int x, int y, int[][] maps){
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, 1});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            int cnt = now[2];
            
            for(int i=0; i<4; i++){
                int new_x = now_x + dx[i];
                int new_y = now_y + dy[i];
                if(new_x >= 0 && new_y >= 0 && new_x < row && new_y < col 
                   && !visited[new_x][new_y] && maps[new_x][new_y] == 1){
                    visited[new_x][new_y] = true;
                    q.add(new int[] {new_x, new_y, cnt+1});
                    if(new_x == row-1 && new_y == col-1){
                        answer = Math.max(cnt+1, answer);
                    }
                }
            }
        }
    }
}