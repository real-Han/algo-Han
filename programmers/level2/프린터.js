function solution(priorities, location) {
    const cnt = new Array(10).fill(0);
    let max = 0;
    let answer = 0;
    const arr = priorities.map((priority) => {
        ++cnt[priority];
        max = Math.max(max, priority);
        return { priority };
    });
    const target = arr[location];
    while (arr.length > 0) {
        const now = arr.shift();
        if (now.priority === max) {
            ++answer;
            if (now === target) break;
            if (--cnt[now.priority] === 0) {
                for (let i = max; i > 0; --i) {
                    if (cnt[i] > 0) {
                        max = i;
                        break;
                    }
                }
            }
        }
        arr.push(now);
    }
    return answer;
}
