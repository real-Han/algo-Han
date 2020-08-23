const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on('line', function (line) {
    let answer = 0;
    for (let i = 3; i < line; ++i) {
        let num = i;
        while (num > 0) {
            const digit = num % 10;
            if (digit > 0 && digit % 3 === 0) {
                ++answer;
            }
            num = parseInt(num / 10);
        }
    }
    console.log(answer);
    rl.close();
}).on('close', function () {
    process.exit();
});
