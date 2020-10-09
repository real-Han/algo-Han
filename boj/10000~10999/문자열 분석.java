import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int[] arr = new int[4];
        while ((input = br.readLine()) != null) {
            for (int i = 0; i < 4; ++i) {
                arr[i] = 0;
            }
            for (char c : input.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    ++arr[0];
                } else if (c >= 'A' && c <= 'Z') {
                    ++arr[1];
                } else if (c >= '0' && c <= '9') {
                    ++arr[2];
                } else {
                    ++arr[3];
                }
            }
            for (int i = 0; i < 4; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}