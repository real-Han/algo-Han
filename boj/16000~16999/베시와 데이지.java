import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int by = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int dy = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int jy = Integer.parseInt(st.nextToken());
        int jx = Integer.parseInt(st.nextToken());

        int b = Math.max(Math.abs(by - jy), Math.abs(bx - jx));
        int d = Math.abs(dy - jy) + Math.abs(dx - jx);
        System.out.println(b < d ? "bessie" : d < b ? "daisy" : "tie");
    }
}