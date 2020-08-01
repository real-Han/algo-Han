/**
 * 끝말잇기 도중
 * 이전에 나왔던 단어가 나오거나
 * 바로 전 단어의 마지막 글자로 시작하는 단어가 아닌 단어가 나오면
 * 어떤 사람이자신의 몇 번째차례에 틀렸는지 반환
 */

function solution(n, words) {
    let idx = 0;
    let count = 1;
    let last = "";
    let wordSet = new Set();

    for (const word of words) {
        idx += 1;
        if (idx > n) {
            idx = 1;
            count += 1;
        }

        //셋에 단어가 있거나, 단어의 시작이 이전 마지막 글자가 아니라면 번호와 차례 반환
        if (wordSet.has(word) || (last && word[0] !== last))
            return [idx, count];

        //정상적인 진행이라면 셋에 단어를 추가하고, 마지막 글자 갱신
        wordSet.add(word);
        last = word[word.length - 1];
    }
    return [0, 0];
}
