import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int M, N;
    static boolean[][] grid;
    static int[] dy = new int[] { 1, 0, 0, -1 };
    static int[] dx = new int[] { 0, 1, -1, 0 };

    static boolean percolate(int y, int x) {
        if (y < 0 || x < 0 || x == N || !grid[y][x])
            return false;
        grid[y][x] = false;
        if (y == M - 1) {
            return true;
        }

        boolean answer = false;
        for (int d = 0; d < 4; ++d) {
            if (!answer) {
                answer |= percolate(y + dy[d], x + dx[d]);
            }
        }
        return answer;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new boolean[M][N];
        String answer = "NO";

        for (int i = 0; i < M; ++i) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; ++j) {
                grid[i][j] = input[j] == '0';
            }
        }

        for (int j = 0; j < N; ++j) {
            if (grid[0][j] && percolate(0, j)) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }
}