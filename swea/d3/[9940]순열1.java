import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 1부터 N까지 모든 수가 나왔는지 확인하는 문제

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; ++tc) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            set.clear();
            while (st.hasMoreTokens() && set.add(Integer.parseInt(st.nextToken())))
                ;
            // while문 통과 후에 set의 크기가 N이라면, 모든 수가 나온 것이다.
            System.out.printf("#%d %s\n", tc, set.size() == N ? "Yes" : "No");
        }
    }
}