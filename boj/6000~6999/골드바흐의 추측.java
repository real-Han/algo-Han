import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int N, max;
    static boolean[] isPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        isPrime = new boolean[1000000];

        max = (int) Math.floor(Math.sqrt(1000000));
        for (int i = 2; i <= max; ++i) {
            if (!isPrime[i]) {
                for (int j = i * i; j < 1000000; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        while ((N = Integer.parseInt(br.readLine())) > 0) {
            max = (int) Math.floor(Math.sqrt(N));
            for (int i = 3; i <= N / 2; ++i) {
                if (!isPrime[i] && !isPrime[N - i]) {
                    sb.append(N).append(" = ").append(i).append(" + ").append(N - i).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}