import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        int[] cnt = new int[10];

        for (char c : N) {
            ++cnt[c - '0'];
        }

        cnt[6] = (cnt[6] + cnt[9] + 1) / 2;
        cnt[9] /= 2;

        // 느리니까 앞으로 사용 X
        System.out.println(Arrays.stream(cnt).max().getAsInt());
    }
}