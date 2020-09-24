import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pre = -1000000;
        String answer = "Good";
        for (String s : br.readLine().split(" ")) {
            int num = Integer.parseInt(s);
            if (num >= pre) {
                pre = num;
            } else {
                answer = "Bad";
                break;
            }
        }
        System.out.println(answer);
    }
}
