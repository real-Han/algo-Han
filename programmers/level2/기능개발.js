function solution(progresses, speeds) {
    const answer = [];
    const N = progresses.length;
    let now = 0;
    for (let i = 0; i < N; ++i) {
        const day = Math.ceil((100 - progresses[i]) / speeds[i]);
        //이 기능이 현재까지 중 가장 오래걸리는 기능이라면 새로운 배포 추가.
        if (day > now) {
            now = day;
            answer.push(1);
        }
        //아니라면 마지막 배포에 기능 추가
        else {
            ++answer[answer.length - 1];
        }
    }
    return answer;
}
