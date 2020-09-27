import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라

class Path implements Comparable<Path> {
    int city;
    int cost;

    public Path(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public int compareTo(Path other) {
        return this.cost - other.cost;
    }
}

class Main {
    final static int INF = 987654321;

    static int N, M;
    static List<Path>[] graph;
    static int[] costs;
    static PriorityQueue<Path> pq;

    static void dijkstra(int from, int to) {
        pq.add(new Path(from, 0));
        costs[from] = 0;

        while (!pq.isEmpty()) {
            Path now = pq.poll();
            if (now.city == to)
                break;
            for (Path next : graph[now.city]) {
                if (costs[now.city] + next.cost < costs[next.city]) {
                    costs[next.city] = costs[now.city] + next.cost;
                    pq.add(new Path(next.city, costs[next.city]));
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        costs = new int[N];
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; ++i) {
            costs[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Path(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken()) - 1;
        int to = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(from, to);

        System.out.println(costs[to]);
    }
}