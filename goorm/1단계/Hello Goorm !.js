const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on('line', function (num) {
    for (let i = 0; i < num; ++i) console.log('Hello Goorm !');
    rl.close();
}).on('close', function () {
    process.exit();
});
