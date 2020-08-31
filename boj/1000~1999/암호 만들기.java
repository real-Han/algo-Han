import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int L, C;
    static char[] arr;
    static StringBuilder password, result;

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static void solve(int idx, int len, int vCnt, int cCnt) {
        if (len == L) {
            if (vCnt >= 1 && cCnt >= 2) {
                result.append(password).append("\n");
            }
            return;
        }
        if (idx == C) {
            return;
        }

        password.append(arr[idx]);
        if (isVowel(arr[idx])) {
            solve(idx + 1, len + 1, vCnt + 1, cCnt);
        } else {
            solve(idx + 1, len + 1, vCnt, cCnt + 1);
        }
        password.deleteCharAt(len);
        solve(idx + 1, len, vCnt, cCnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        password = new StringBuilder();
        result = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; ++i) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        solve(0, 0, 0, 0);
        System.out.println(result);
    }
}