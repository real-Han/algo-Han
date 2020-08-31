import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, idx;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        idx = 0;
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i > 0; --i) {
            if (arr[i] > arr[i - 1]) {
                idx = i;
                break;
            }
        }
        if (idx > 0) {
            for (int i = N - 1; i >= idx; --i) {
                if (arr[i] > arr[idx - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[idx - 1];
                    arr[idx - 1] = tmp;
                    break;
                }
            }
            Arrays.sort(arr, idx, N);
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1));
        } else {
            System.out.println(-1);
        }
    }
}