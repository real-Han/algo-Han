import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int N, sum, avg, ans;
    static int[] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());

            sum = 0;
            for (int i = 0; i < N; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            avg = sum / N;
            ans = 0;
            for (int i = 0; i < N; ++i) {
                if (arr[i] <= avg)
                    ++ans;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
