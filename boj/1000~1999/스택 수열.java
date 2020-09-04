import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    static int N, target;
    static int[] arr;
    static Stack<Integer> s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        s = new Stack<>();
        target = 0;
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; ++i) {
            s.add(i);
            sb.append("+\n");
            while (!s.isEmpty() && s.peek() == arr[target]) {
                s.pop();
                ++target;
                sb.append("-\n");
            }
        }
        System.out.println(s.isEmpty() ? sb : "NO");
    }
}