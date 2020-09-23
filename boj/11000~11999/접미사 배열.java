import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0, len = s.length(); i < len; ++i) {
            arr.add(s.substring(i));
        }
        Collections.sort(arr);
        for (String suffix : arr) {
            System.out.println(suffix);
        }
    }
}
