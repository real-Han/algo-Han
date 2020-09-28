import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//단순한 투포인터 문제
class Solution {
    static int N, K, left, right, answer;
    static int[] diamonds;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            diamonds = new int[N];
            for (int i = 0; i < N; ++i) {
                diamonds[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(diamonds);
            left = 0;
            right = 0;
            answer = 1;
            while (++right < N) {
                while (diamonds[right] - diamonds[left] > K)
                    ++left;
                answer = Math.max(answer, right - left + 1);
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}