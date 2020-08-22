const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", function (line) {
    let sum = 0;
    for (let i = 1; i <= line; ++i) {
        if (i % 3 === 0 || i % 5 === 0) sum += i;
    }
    console.log(sum);
    rl.close();
}).on("close", function () {
    process.exit();
});
