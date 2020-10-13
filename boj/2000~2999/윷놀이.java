import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 4; ++j) {
                if (st.nextToken().charAt(0) == '0')
                    ++cnt;
            }
            cnt = (cnt + 4) % 5;
            System.out.println((char) (cnt + 'A'));
        }
    }
}