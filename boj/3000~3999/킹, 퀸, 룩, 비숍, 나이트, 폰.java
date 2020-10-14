import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    final static int[] CHESS = new int[] { 1, 1, 2, 2, 2, 8 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < CHESS.length; ++i) {
            System.out.print(CHESS[i] - Integer.parseInt(st.nextToken()) + " ");
        }
    }
}