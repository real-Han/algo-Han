import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static class Problem implements Comparable<Problem> {
        int no;
        int score;

        public Problem(int no, int score) {
            this.no = no;
            this.score = score;
        }

        public int compareTo(Problem other) {
            return other.score - this.score;
        }
    }

    final static int NUMBER_OF_PROBLEMS = 8;

    static Problem[] problems;
    static int[] numbers;
    static int sum;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        problems = new Problem[NUMBER_OF_PROBLEMS];
        numbers = new int[5];
        sum = 0;
        for (int i = 0; i < NUMBER_OF_PROBLEMS; ++i) {
            problems[i] = new Problem(i + 1, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(problems);
        for (int i = 0; i < 5; ++i) {
            sum += problems[i].score;
            numbers[i] = problems[i].no;
        }
        Arrays.sort(numbers);
        System.out.println(sum);
        for (int i = 0; i < 5; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }
}