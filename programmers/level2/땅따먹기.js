function solution(land) {
    var answer = 0;
    const N = land.length;
    land = [new Array(4).fill(0), ...land];
    const dp = new Array(N + 1).fill(null).map(() => new Array(4).fill(0));
    for (let i = 1; i <= N; ++i) {
        for (let j = 0; j < 4; ++j) {
            for (let k = 0; k < 4; ++k) {
                if (j !== k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k]);
                }
            }
            dp[i][j] += land[i][j];
        }
    }
    return Math.max(...dp[N]);
}
