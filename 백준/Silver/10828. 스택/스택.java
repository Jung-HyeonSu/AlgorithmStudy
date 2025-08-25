import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for(int t=0; t<T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")){
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if(str.equals("pop")){
				if(stack.empty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(stack.pop()).append("\n");
				}
			}
			else if(str.equals("size")){
				sb.append(stack.size()).append("\n");
			}
			else if(str.equals("empty")){
				if(stack.empty()){
					sb.append(1).append("\n");
				}
				else{
					sb.append(0).append("\n");
				}
			}
			else if(str.equals("top")){
				if(stack.empty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(stack.lastElement()).append("\n");
				}
			}

		}

		System.out.print(sb);
    }
}
