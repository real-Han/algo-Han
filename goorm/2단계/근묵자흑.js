const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    const [N, K] = input
        .shift()
        .split(' ')
        .map(num => parseInt(num));
    console.log(Math.ceil((N - 1) / (K - 1)));
    process.exit();
});
