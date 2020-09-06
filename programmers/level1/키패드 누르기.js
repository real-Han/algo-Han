function solution(numbers, hand) {
    let answer = '';
    let left = 9;
    let right = 11;
    const dist = new Array(12).fill(null).map(() => new Array(12).fill(0));
    for (let i = 0; i < 11; ++i) {
        for (let j = i + 1; j < 12; ++j) {
            dist[i][j] =
                Math.abs(parseInt(j / 3) - parseInt(i / 3)) +
                Math.abs((j % 3) - (i % 3));
            dist[j][i] = dist[i][j];
        }
    }
    numbers.forEach(number => {
        number = parseInt(number) - 1;
        if (number < 0) number = 10;
        if (number % 3 === 0) {
            answer += 'L';
            left = number;
        } else if (number % 3 === 2) {
            answer += 'R';
            right = number;
        } else {
            const LD = dist[left][number];
            const RD = dist[right][number];
            if (LD < RD || (LD === RD && hand === 'left')) {
                answer += 'L';
                left = number;
            } else {
                answer += 'R';
                right = number;
            }
        }
    });

    return answer;
}
