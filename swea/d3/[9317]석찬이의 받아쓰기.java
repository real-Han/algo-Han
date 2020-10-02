import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int N, answer;
    static char[] A, B;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            A = br.readLine().toCharArray();
            B = br.readLine().toCharArray();
            for (int i = 0; i < N; ++i) {
                if (A[i] == B[i])
                    ++answer;
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}