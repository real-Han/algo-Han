import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0, stick = 0;
        char last = '(';
        for (char c : br.readLine().toCharArray()) {
            if (c == '(') {
                ++stick;
            } else {
                --stick;
                if (last == '(') {
                    cnt += stick;
                } else {
                    ++cnt;
                }
            }
            last = c;
        }
        System.out.println(cnt);
    }
}