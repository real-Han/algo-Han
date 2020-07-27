function solution(s) {
    let answer = 1;
    const N = s.length;
    let len, head, tail;
    for (let i = 0; i < N; ++i) {
        len = 1;
        head = i - 1;
        tail = i + 1;
        while (head >= 0 && tail < N && s[head--] === s[tail++])
            answer = Math.max(answer, (len += 2));
        len = 0;
        head = i;
        tail = i + 1;
        while (head >= 0 && tail < N && s[head--] === s[tail++])
            answer = Math.max(answer, (len += 2));
    }

    return answer;
}
