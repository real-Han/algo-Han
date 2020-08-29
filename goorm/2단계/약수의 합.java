import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long result = 0;
		for (long i = 1, max = N; i < max; ++i) {
			if (N % i == 0) {
				result += i;
				if (i == N / i)
					break;
				result += max = N / i;
			}
		}
		System.out.println(result);
	}
}