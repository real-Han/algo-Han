import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        int pre = 1000;
        for (int i = 0; i < N; ++i) {
            int height = Integer.parseInt(st.nextToken());
            if (height <= pre) {
                start = height;
            }
            pre = height;
            answer = Math.max(answer, height - start);
        }
        System.out.println(answer);
    }
}