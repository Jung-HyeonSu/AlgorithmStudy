import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int[] result;
	static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		result = new int[N+1];

		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}

		for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

		bfs(R);

		for(int i=1; i<N+1; i++){
			System.out.println(result[i]);
		}
	}

	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		count = 1;
		visited[start] = true;
		result[start] = count;
		queue.add(start);

		while(!queue.isEmpty()){
			int now = queue.poll();
			for(int next : graph[now]){
				if(!visited[next]){
					count++;
					visited[next] = true;
					result[next] = count;
					queue.add(next);
				}
			}
		}
	}
}