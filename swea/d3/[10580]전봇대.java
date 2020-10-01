import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
	static int N, answer;
	static int[][] poll;

	static Comparator<int[]> pollComparator;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		pollComparator = new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return p1[0] - p2[0];
			}
		};

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			poll = new int[N][2];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				poll[i][0] = Integer.parseInt(st.nextToken());
				poll[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(poll, pollComparator);

			for (int i = 0; i < N; ++i) {
				for (int j = i + 1; j < N; ++j) {
					if (poll[i][1] > poll[j][1])
						++answer;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}