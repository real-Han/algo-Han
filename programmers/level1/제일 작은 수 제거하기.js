function solution(arr) {
    let min = Number.MAX_VALUE;
    let minIdx = 0;
    arr.forEach((num, idx) => {
        if (num < min) {
            min = num;
            minIdx = idx;
        }
    });
    arr.splice(minIdx, 1);
    return arr.length > 0 ? arr : [-1];
}
