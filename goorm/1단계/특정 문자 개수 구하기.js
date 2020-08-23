const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    let cnt = 0;
    const [str, target] = [input.shift(), input.shift()];
    for (const c of str) cnt += c === target;
    console.log(cnt);
    process.exit();
});
