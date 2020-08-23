const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on('line', function (num) {
    console.log(parseInt((num * (num - 1)) / 2));
    rl.close();
}).on('close', function () {
    process.exit();
});
