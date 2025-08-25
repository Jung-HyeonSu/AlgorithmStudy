import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++){
			int count = 0;
			String str = br.readLine();
			for(int i=0; i<str.length(); i++){
				if(str.charAt(i) == '('){
					count++;
				}
				else{
					count--;
				}

				if(count < 0){
					break;
				}
			}
			if(count == 0 ){
				sb.append("YES").append("\n");
			}
			else{
				sb.append("NO").append("\n");
			}
		}

		System.out.print(sb);
    }
}
