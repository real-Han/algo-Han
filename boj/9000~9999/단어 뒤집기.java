import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            for (String s : br.readLine().split(" ")) {
                for (int j = s.length() - 1; j >= 0; --j)
                    sb.append(s.charAt(j));
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb);
    }
}