import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; ++i) {
			int answer = 1;
			char last = 0;
			int cnt = 0;
			for (char c : br.readLine().toCharArray()) {
				if (c == last) {
					answer = Math.max(answer, ++cnt);
				} else {
					last = c;
					cnt = 1;
				}
			}
			System.out.println(answer);
		}
	}
}