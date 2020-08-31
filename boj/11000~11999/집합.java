import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    final static int ALL = (1 << 20) - 1;
    static int S, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        S = 0;
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    S |= 1 << Integer.parseInt(st.nextToken()) - 1;
                    break;
                case "remove":
                    S &= ALL - (1 << Integer.parseInt(st.nextToken()) - 1);
                    break;
                case "check":
                    sb.append((S & (1 << Integer.parseInt(st.nextToken()) - 1)) > 0 ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    S ^= 1 << Integer.parseInt(st.nextToken()) - 1;
                    break;
                case "all":
                    S = ALL;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}