const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on('line', function (line) {
    const n = parseInt(line);
    const arr = new Array(n);
    for (let i = 1; i <= n; ++i) {
        console.log(
            arr
                .fill(i)
                .map((num, idx) => num + idx * n + ' ')
                .join('')
        );
    }
    rl.close();
}).on('close', function () {
    process.exit();
});
