import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long min = 1;
        long max = Long.parseLong(br.readLine());
        long mid = 0;

        while (min < max) {
            mid = (min + max + 1) / 2;
            if ((mid * (mid + 1) / 2) <= S) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}