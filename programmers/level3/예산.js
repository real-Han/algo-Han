/**
 * 문제
 * 정해진 국가 예산 안에서 여러 지방의 예산요청에 대해 예산을 분배하는 문제.
 * 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정.
 * 아닐 경우 상한액을 정해서 상한액을 초과할 경우 상한액만큼 배정.
 * M = 국가 예산의 총액
 * budgets = 각 지방의 예산 요청
 *
 * 해결 방법
 * 이분탐색으로 해결한다.
 * 주의할 점은 상한액을 '최소' 로 설정해야 정답 처리가 된다.
 * 그렇기 때문에 최대 범위를 설정할 때, 예산요청 중 가장 큰 액수를 기준으로 설정하여
 * 상한액이 불필요하게 증가하는 일을 막아야 한다.
 *
 * 얘들 들어, budgets=[1,2,3,4]  M=100인 입력에 대해
 * 25가 아닌 4를 리턴해야 한다.
 */

function solution(budgets, M) {
    let min, mid, max, sum;
    min = 0;
    max = 0;
    budgets.forEach((budget) => (max = Math.max(max, budget)));
    while (min < max) {
        mid = Math.round((min + max) / 2);
        sum = 0;
        for (const budget of budgets) {
            if ((sum += budget < mid ? budget : mid) >= M) break;
        }
        if (sum > M) max = mid - 1;
        else min = mid;
    }
    return min;
}
