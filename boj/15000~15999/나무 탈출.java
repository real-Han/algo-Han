import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N;
    static long move;
    static boolean[] vtd;
    static List<Integer>[] tree;

    static void escape(int idx, int depth) {
        if (idx > 1 && tree[idx].size() == 1) {
            move += depth;
            return;
        }
        vtd[idx] = true;
        for (int child : tree[idx]) {
            if (!vtd[child]) {
                escape(child, depth + 1);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        move = 0;
        vtd = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        escape(1, 0);
        System.out.println(move % 2 == 0 ? "No" : "Yes");
    }
}