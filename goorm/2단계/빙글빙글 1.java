import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        int[] dy = { 0, 1, 0, -1 };
        int[] dx = { 1, 0, -1, 0 };
        int y = 0;
        int x = N - 1;
        int len = N - 1;
        int dir = 1;

        for (int i = 0; i < N; ++i) {
            arr[0][i] = '#';
            for (int j = 0; i > 0 && j < N; ++j) {
                arr[i][j] = ' ';
            }
        }
        while (len > 0) {
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < len; ++j) {
                    y += dy[dir];
                    x += dx[dir];
                    arr[y][x] = '#';
                }
                dir = (dir + 1) % 4;
            }
            len -= 2;
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}