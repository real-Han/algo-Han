function solution(d, budget) {
    return d
        .sort((a, b) => a - b)
        .reduce((ans, num) => {
            if (num <= budget) {
                ++ans;
                budget -= num;
            }
            return ans;
        }, 0);
}
