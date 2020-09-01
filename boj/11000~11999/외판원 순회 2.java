import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    final static int MAX = 987654321;
    static int N, min, all, start;
    static int[][] W;

    static void solve(int idx, int cost, int vtd) {
        if (vtd == all) {
            min = Math.min(min, cost + W[idx][start]);
            return;
        }
        for (int i = 0; i < N; ++i) {
            if ((vtd & (1 << i)) == 0 && W[idx][i] < MAX) {
                solve(i, cost + W[idx][i], vtd | (1 << i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        min = MAX;
        all = (1 << N) - 1;
        W = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                int cost = Integer.parseInt(st.nextToken());
                W[i][j] = cost > 0 ? cost : MAX;
            }
        }

        for (int i = 0; i < N; ++i) {
            start = i;
            solve(i, 0, 1 << i);
        }

        System.out.println(min);
    }
}