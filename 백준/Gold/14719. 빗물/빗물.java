import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String hw = br.readLine();
        StringTokenizer st = new StringTokenizer(hw, " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] height = new int[w];
        String block = br.readLine();
        StringTokenizer st2 = new StringTokenizer(block, " ");
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st2.nextToken());
        }

        int rain = 0;
        for(int i=1; i<w-1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for(int j=0; j<i; j++){
                if(height[j]>leftMax){
                    leftMax = height[j];
                }
            }
            for(int j=i+1; j<w; j++){
                if(height[j]>rightMax){
                    rightMax = height[j];
                }
            }
            if(height[i] < leftMax && height[i] < rightMax){
                if(leftMax > rightMax){
                    rain += rightMax - height[i];
                }
                else{
                    rain += leftMax - height[i];
                }
            }
        }
        System.out.print(rain);
    }
}