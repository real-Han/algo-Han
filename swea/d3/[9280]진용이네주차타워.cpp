#include <iostream>
#include <queue>

using namespace std;

/**
 * 주차 가능한 공간 중 번호가 가장 작은 주차 공간에 주차하도록 한다.
 * -> 주차장을 우선순위큐로 만들어 번호가 가장 작은 공간을 바로 사용한다.
 * -> 나가는 차량이 있으면 다시 주차 공간의 번호를 우선순위큐에 넣어준다.
 * 
 * 만약 주차를 기다리는 차량이 여러 대라면, 입구의 대기장소에서 자기 차례를 기다려야 한다.
 * -> 들어오는 입력에 대해 바로 처리하지 않고 큐에 넣어넣고 처리한다.
**/

int main()
{
    int T, N, M;
    int total, order;
    int feePerWeights[100];
    priority_queue<int, vector<int>, greater<int>> parkingLot;
    queue<int> q;
    int weights[2001];
    int parkingIdxs[2001];
    scanf("%d", &T);
    for (int tc = 1; tc <= T; ++tc)
    {
        while (!parkingLot.empty())
            parkingLot.pop();
        scanf("%d %d", &N, &M);
        for (int i = 0; i < N; ++i)
        {
            scanf("%d", &feePerWeights[i]);
            parkingLot.push(i);
        }
        for (int i = 1; i <= M; ++i)
        {
            scanf("%d", &weights[i]);
        }

        total = 0;
        M <<= 1;
        for (int i = 0; i < M; ++i)
        {
            scanf("%d", &order);
            //들어온 입력이 양수이면 큐에 넣어준다.
            if (order > 0)
            {
                q.push(order);
            }
            //음수이면 나가는 차량이므로 해당 차량의 주차 공간 번호를 반납한다.
            else
            {
                parkingLot.push(parkingIdxs[order * -1]);
            }
            //주차장에 자리가 있고 대기중인 차량이 있다면, 주차한다.
            if (!parkingLot.empty() && !q.empty())
            {
                int car = q.front();
                q.pop();
                int parkingIdx = parkingLot.top();
                parkingLot.pop();
                total += weights[car] * feePerWeights[parkingIdx];
                parkingIdxs[car] = parkingIdx;
            }
        }
        printf("#%d %d\n", tc, total);
    }
    return 0;
}
