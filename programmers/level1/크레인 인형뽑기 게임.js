function solution(board, moves) {
    let answer = 0;
    const N = board.length;

    let bucket = [];
    for (let move of moves) {
        --move;
        for (let i = 0; i < N; ++i) {
            if (board[i][move] > 0) {
                if (
                    bucket.length > 0 &&
                    bucket[bucket.length - 1] === board[i][move]
                ) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(board[i][move]);
                }
                board[i][move] = 0;
                break;
            }
        }
    }

    return answer;
}
