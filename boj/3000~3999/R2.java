import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int R1, S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R1 = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		System.out.println(S + S - R1);
	}
}