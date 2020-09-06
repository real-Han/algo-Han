import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        boolean tag = false;
        for (char c : br.readLine().toCharArray()) {
            switch (c) {
                case '<':
                    tag = true;
                case ' ':
                    while (!s.empty())
                        sb.append(s.pop());
                    sb.append(c);
                    break;
                default:
                    if (tag)
                        sb.append(c);
                    else
                        s.add(c);
                    break;
            }
            if (c == '>')
                tag = false;
        }
        while (!s.empty())
            sb.append(s.pop());
        System.out.println(sb);
    }
}