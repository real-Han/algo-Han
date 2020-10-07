import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int[] candies;
    static int N, answer, DW, bro;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            candies = new int[N];
            answer = 0;
            DW = 0;
            bro = 0;
            for (int i = 0; i < N; ++i) {
                int candy = Integer.parseInt(st.nextToken());
                candies[i] = candy;
                answer += candy;
                DW ^= candy;
            }

            Arrays.sort(candies);
            for (int candy : candies) {
                answer -= candy;
                DW ^= candy;
                bro ^= candy;
                if (DW == bro)
                    break;
            }
            sb.append('#').append(tc).append(' ').append(answer == 0 ? "NO" : answer).append("\n");
        }
        System.out.println(sb);
    }
}