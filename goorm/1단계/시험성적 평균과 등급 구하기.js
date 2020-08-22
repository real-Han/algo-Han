const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const getGrade = (score) => {
    switch (Math.floor(score / 10)) {
        case 10:
        case 9:
            return 'A';
        case 8:
            return 'B';
        case 7:
            return 'C';
        case 6:
            return 'D';
    }
    return 'F';
};

rl.on('line', function (line) {
    const total = (
        line.split(' ').reduce((acc, score) => acc + parseInt(score), 0) / 3
    ).toFixed(2);
    console.log(total, getGrade(total));
    rl.close();
}).on('close', function () {
    process.exit();
});
