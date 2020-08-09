function solution(s) {
    let [min, max] = [Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER];
    s.split(" ").forEach((num) => {
        min = Math.min(min, num);
        max = Math.max(max, num);
    });
    return `${min} ${max}`;
}
