const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on('line', function (line) {
    const [a, b] = line.split(' ');
    console.log(parseInt(a) < parseInt(b) ? a : b);
    rl.close();
}).on('close', function () {
    process.exit();
});
