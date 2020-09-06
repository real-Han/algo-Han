function solution(n, arr1, arr2) {
    const answer = [];
    const start = 1 << n;
    for (let i = 0; i < n; ++i) {
        const row = arr1[i] | arr2[i];
        let decoded = '';
        for (let j = 1; j <= n; ++j) {
            decoded += (row & (start >> j)) > 0 ? '#' : ' ';
        }
        answer.push(decoded);
    }
    return answer;
}
