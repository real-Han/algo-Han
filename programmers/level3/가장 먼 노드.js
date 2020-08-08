/**
 * 노드 사이에 가중치가 없으므로
 * BFS로 순회하면 해당 노드까지의 최단 거리를 구할 수 있다.
 * 이 최단 거리가 가장 긴, 가장 멀리 떨어진 노드의 갯수를 구하는 문제.
 */

function solution(n, edge) {
    let distance = -1;
    const graph = new Array(n).fill(null).map(() => []);
    const dist = new Array(n).fill(0);
    const vtd = new Array(n).fill(false);
    const queue = [];
    //양방향이라 서로 넣어줌
    for (let [a, b] of edge) {
        graph[--a].push(--b);
        graph[b].push(a);
    }
    queue.push(0);
    vtd[0] = true;
    while (queue.length > 0) {
        ++distance;
        //현재 큐의 길이 == 같은 거리에 있는 노드의 수
        const qLen = queue.length;
        for (let i = 0; i < qLen; ++i) {
            const node = queue.shift();
            dist[node] = distance;
            graph[node].forEach((to) => {
                //현재 노드와 인접한 노드 중 방문하지 않은 노드를 큐에 추가
                if (!vtd[to]) {
                    vtd[to] = true;
                    queue.push(to);
                }
            });
        }
    }
    //반복이 끝났을때의 거리가 가장 먼 거리이므로, 이 거리와 각 노드까지의 거리를 비교하여 같으면 +1
    return dist.reduce((acc, val) => (acc += val === distance));
}
