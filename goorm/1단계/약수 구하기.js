const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", function (num) {
    const factors = [];
    for (let i = 1; i <= num; ++i) {
        if (num % i === 0) factors.push(i);
    }
    console.log(factors.join(" ") + " ");
    rl.close();
}).on("close", function () {
    process.exit();
});
