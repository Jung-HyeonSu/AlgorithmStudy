import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new LinkedList<>();
		for(int t=0; t<T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push_front")){
				int num = Integer.parseInt(st.nextToken());
				q.addFirst(num);
			}
            else if(str.equals("push_back")){
				int num = Integer.parseInt(st.nextToken());
				q.addLast(num);
			}
			else if(str.equals("pop_front")){
				if(q.isEmpty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(q.pollFirst()).append("\n");
				}
			}
            else if(str.equals("pop_back")){
				if(q.isEmpty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(q.pollLast()).append("\n");
				}
			}
			else if(str.equals("size")){
				sb.append(q.size()).append("\n");
			}
			else if(str.equals("empty")){
				if(q.isEmpty()){
					sb.append(1).append("\n");
				}
				else{
					sb.append(0).append("\n");
				}
			}
			else if(str.equals("front")){
				if(q.isEmpty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(q.peekFirst()).append("\n");
				}
			}
            else if(str.equals("back")){
				if(q.isEmpty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(q.peekLast()).append("\n");
				}
			}

		}

		System.out.print(sb);
    }
}