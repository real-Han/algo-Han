import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static boolean ABCDE;
    static ArrayList<Integer>[] friends;
    static boolean[] chk;

    static void solve(int idx, int depth) {
        if (depth == 5)
            ABCDE = true;
        if (ABCDE)
            return;
        for (int friend : friends[idx]) {
            if (!chk[friend]) {
                chk[friend] = true;
                solve(friend, depth + 1);
                chk[friend] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ABCDE = false;

        friends = new ArrayList[N];
        chk = new boolean[N];
        for (int i = 0; i < N; ++i) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i = 0; i < N && !ABCDE; ++i) {
            chk[i] = true;
            solve(i, 1);
            chk[i] = false;
        }
        System.out.println(ABCDE ? 1 : 0);
    }
}