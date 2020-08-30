const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const input = [];

const gcd = (a, b) => {
    while (b !== 0) {
        const tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
};
const lcm = (a, b) => (a * b) / gcd(a, b);

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    const T = parseInt(input.shift());
    for (let i = 0; i < T; ++i) {
        const [a, b] = input
            .shift()
            .split(' ')
            .map(num => parseInt(num));
        console.log(lcm(a, b));
    }
});
