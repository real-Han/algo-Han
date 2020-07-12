#include <iostream>

int main()
{
    int T, N, K;
    scanf("%d", &T);
    for (int tc = 1; tc <= T; ++tc)
    {
        scanf("%d %d", &N, &K);
        printf("#%d %d\n", tc, N % K == 0 ? 0 : 1);
    }
    return 0;
}
