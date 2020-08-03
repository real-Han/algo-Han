//dfs
function solve(n, computers, idx, chk) {
    chk[idx] = true;
    for (let i = 0; i < n; ++i) {
        if (computers[idx][i] && !chk[i]) {
            solve(n, computers, i, chk);
        }
    }
}

function solution(n, computers) {
    const chk = new Array(n).fill(false);
    let answer = 0;
    for (let i = 0; i < n; ++i) {
        if (!chk[i]) {
            ++answer;
            solve(n, computers, i, chk);
        }
    }
    return answer;
}
