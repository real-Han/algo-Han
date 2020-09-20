/**
 * 문제
 * begin 단어에서 출발하여 words 안에 들어있는 단어로 변경이 가능하다.
 * 한 번에 한 개의 알파벳만 바꿀 수 있다.
 * 이때 begin에서 target으로 변환하려면 최소 몇 단계를 거쳐야 하는지 찾아야한다.
 * 만약 변환할 수 없다면 0을 리턴한다.
 *
 * 풀이
 * 최소 횟수를 찾기 위해 BFS를 사용.
 * 변환 가능한 단어들을 Set으로 만들어 불필요한 반복을 줄임.
 */

function solution(begin, target, words) {
    let [answer, cnt] = [0, 0];
    const q = [begin];
    const wordSet = new Set(words);

    //1을 리턴 -> 한 개의 알파벳을 바꿔 변환할 수 있다.
    const diffCount = (a, b) => {
        let diff = 0;
        for (let i = 0; i < a.length; ++i) {
            diff += a[i] !== b[i];
        }
        return diff;
    };

    while (q.length > 0 && answer === 0) {
        for (let i = 0, len = q.length; i < len; ++i) {
            const w = q.shift();
            if (w === target) {
                answer = cnt;
                break;
            }
            //어떤 단어를 거쳐왔는지는 중요하지 않다.
            // -> 한번 등장하면 제거해도 무방
            //중복되는 단어가 없어 foreach 내부에서 바로 제거
            wordSet.forEach(word => {
                if (diffCount(w, word) === 1) {
                    q.push(word);
                    wordSet.delete(word);
                }
            });
        }
        ++cnt;
    }
    return answer;
}
