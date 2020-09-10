import java.util.Arrays;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		int N = phone_book.length;
		Arrays.sort(phone_book, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
		for (int i = 0; i < N - 1 && answer; ++i) {
			String a = phone_book[i];
			loop: for (int j = i + 1; j < N && answer; ++j) {
				String b = phone_book[j];
				for (int k = 0, len = a.length(); k < len; ++k) {
					if (a.charAt(k) != b.charAt(k))
						continue loop;
				}
				answer = false;
			}
		}
		return answer;
	}
}