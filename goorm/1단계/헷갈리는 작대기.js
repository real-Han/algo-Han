const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const STICKS = ['1', 'I', 'l', '|'];

rl.on('line', function (line) {
    const cnt = {};
    STICKS.forEach(stick => (cnt[stick] = 0));
    for (const c of line) {
        if (STICKS.some(stick => stick === c)) ++cnt[c];
    }
    STICKS.forEach(stick => {
        console.log(cnt[stick]);
    });
    rl.close();
}).on('close', function () {
    process.exit();
});
