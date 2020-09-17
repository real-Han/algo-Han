import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static long answer;
	static PriorityQueue<Long> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer=0;
		pq=new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		for(int i=0;i<M;++i) {
			long sum = pq.poll()+pq.poll();
			pq.add(sum);
			pq.add(sum);
		}
		while(!pq.isEmpty()) {
			answer+=pq.poll();
		}
		System.out.println(answer);
	}
}