const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on('line', function (line) {
    const [A, B] = line.split(' ');
    console.log(Math.floor(A / B), A % B);
}).on('close', function () {
    process.exit();
});
