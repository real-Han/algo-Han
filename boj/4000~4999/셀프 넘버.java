class Main {
    final static int MAX = 10000;
    static int num, sum;
    static boolean[] chk;

    public static void main(String args[]) throws Exception {
        chk = new boolean[MAX + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX; ++i) {
            if (!chk[i]) {
                sum = i;
                while (true) {
                    num = sum;
                    while (num > 0) {
                        sum += num % 10;
                        num /= 10;
                    }
                    if (sum > MAX || chk[sum])
                        break;
                    chk[sum] = true;
                }
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}