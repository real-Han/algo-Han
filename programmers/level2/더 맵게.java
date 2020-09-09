import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Long> pq;

    public int solution(int[] scoville, int K) {
        int cnt = 0;
        pq = new PriorityQueue<>();
        for (int scov : scoville)
            pq.add((long) scov);

        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + (pq.poll() << 1));
            ++cnt;
        }

        return pq.peek() >= K ? cnt : -1;
    }
}