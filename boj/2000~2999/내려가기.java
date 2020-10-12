import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int N;
    static int[] arr, min, max, lastMin, lastMax;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[3];
        min = new int[3];
        max = new int[3];
        lastMin = new int[3];
        lastMax = new int[3];

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < 3; ++j) {
                arr[j] = br.read() - '0';
                if (j < 2) {
                    br.read();
                }
                lastMin[j] = min[j];
                lastMax[j] = max[j];
            }
            br.readLine();
            min[0] = arr[0] + Math.min(lastMin[0], lastMin[1]);
            min[1] = arr[1] + Math.min(lastMin[0], Math.min(lastMin[1], lastMin[2]));
            min[2] = arr[2] + Math.min(lastMin[1], lastMin[2]);
            max[0] = arr[0] + Math.max(lastMax[0], lastMax[1]);
            max[1] = arr[1] + Math.max(lastMax[0], Math.max(lastMax[1], lastMax[2]));
            max[2] = arr[2] + Math.max(lastMax[1], lastMax[2]);
        }

        System.out.printf("%d %d\n", Math.max(max[0], Math.max(max[1], max[2])),
                Math.min(min[0], Math.min(min[1], min[2])));
    }
}