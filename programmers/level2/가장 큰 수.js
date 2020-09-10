function solution(numbers) {
    return numbers
        .sort((a, b) => {
            const sa = a + '';
            const sb = b + '';
            return parseInt(sb + sa) - parseInt(sa + sb);
        })
        .reduce((ans, num) => {
            ans += num;
            return ans[0] === '0' ? '0' : ans;
        }, '');
}
