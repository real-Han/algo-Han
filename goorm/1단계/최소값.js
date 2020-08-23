const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    const N = input.shift();
    const answer = input
        .shift()
        .split(' ')
        .reduce(
            (min, num) => (min = Math.min(min, num)),
            Number.MAX_SAFE_INTEGER
        );
    console.log(answer);
    process.exit();
});
