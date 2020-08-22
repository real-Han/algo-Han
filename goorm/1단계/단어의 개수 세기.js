const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", function (line) {
    console.log(line.split(" ").filter((word) => word !== "").length);
    rl.close();
}).on("close", function () {
    process.exit();
});
