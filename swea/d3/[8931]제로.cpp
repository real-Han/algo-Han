#include <iostream>
#include <stack>

using namespace std;

//스택을 사용해보자
int main()
{
    int T, N;
    stack<int> book;
    int num, total;

    scanf("%d", &T);
    for (int tc = 1; tc <= T; ++tc)
    {
        scanf("%d", &N);
        for (int i = 0; i < N; ++i)
        {
            scanf("%d", &num);
            if (num > 0)
                book.push(num);
            else
                book.pop();
        }
        total = 0;
        while (!book.empty())
        {
            total += book.top();
            book.pop();
        }
        printf("#%d %d\n", tc, total);
    }
    return 0;
}
