import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int S, time, next;
    static Queue<Integer> q;
    static HashSet<Integer> chk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        chk = new HashSet<>();
        time = 0;
        q.add(1);
        loop: while (true) {
            for (int i = 0, len = q.size(); i < len; ++i) {
                int clip = q.peek() / 10000;
                int imo = q.poll() % 10000;
                if (imo == S)
                    break loop;
                if (imo > 0) {
                    next = imo * 10000 + imo;
                    if (chk.add(next))
                        q.add(next);
                }
                next = clip * 10000 + imo + clip;
                if (chk.add(next))
                    q.add(next);
                if (imo - 1 > 0) {
                    next = clip * 10000 + imo - 1;
                    if (chk.add(next))
                        q.add(next);
                }

            }
            ++time;
        }
        System.out.println(time);

    }
}