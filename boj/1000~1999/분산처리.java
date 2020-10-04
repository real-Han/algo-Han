import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int a, b, answer;
        for (int t = 0; t < T; ++t) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            answer = 1;
            for (int i = 0; i < b; ++i) {
                answer = (answer * a) % 10;
            }
            System.out.println(answer == 0 ? 10 : answer);
        }
    }
}