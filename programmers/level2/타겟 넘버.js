function solution(numbers, target) {
    const N = numbers.length;
    let answer = 0;
    const solve = (idx, val) => {
        if (idx === N) {
            answer += val === target;
            return;
        }
        solve(idx + 1, val + numbers[idx]);
        solve(idx + 1, val - numbers[idx]);
    };
    solve(0, 0);
    return answer;
}
