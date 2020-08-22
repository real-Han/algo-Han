const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    const str = input.shift();
    let [start, len] = input
        .shift()
        .split(' ')
        .map(num => parseInt(num));
    --start;
    console.log(str.substring(start, start + len));
    process.exit();
});
