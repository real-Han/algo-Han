import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        for (char c : br.readLine().toCharArray()) {
            ++cnt[c - 'a'];
        }
        for (int num : cnt) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
