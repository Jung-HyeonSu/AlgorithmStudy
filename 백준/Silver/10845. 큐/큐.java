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
			if(str.equals("push")){
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
			}
			else if(str.equals("pop")){
				if(q.isEmpty()){
					sb.append(-1).append("\n");
				}
				else{
					sb.append(q.poll()).append("\n");
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
					sb.append(q.peek()).append("\n");
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
