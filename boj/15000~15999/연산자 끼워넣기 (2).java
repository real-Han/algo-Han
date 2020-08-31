import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, max, min;
    static int[] arr, operators;

    static void solve(int idx, int value) {
        if (idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (operators[i] > 0) {
                --operators[i];
                switch (i) {
                    case 0:
                        solve(idx + 1, value + arr[idx]);
                        break;
                    case 1:
                        solve(idx + 1, value - arr[idx]);
                        break;
                    case 2:
                        solve(idx + 1, value * arr[idx]);
                        break;
                    case 3:
                        solve(idx + 1, value / arr[idx]);
                        break;
                }
                ++operators[i];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operators = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
}