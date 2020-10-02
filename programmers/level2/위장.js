function solution(clothes) {
    let answer = 1;
    const map = new Map();
    clothes.forEach(([name, type]) => {
        if (map.has(type)) {
            map.set(type, map.get(type) + 1);
        } else {
            map.set(type, 1);
        }
    });
    for (const cnt of map.values()) {
        answer *= cnt + 1;
    }
    return answer - 1;
}
