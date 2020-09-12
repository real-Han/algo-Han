import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public int compareTo(Student s) {
        if (this.korean != s.korean)
            return s.korean - this.korean;
        if (this.english != s.english)
            return this.english - s.english;
        if (this.math != s.math)
            return s.math - this.math;
        return this.name.compareTo(s.name);
    }
}

class Main {
    static int N;
    static Student[] students;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        students = new Student[N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students);
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}