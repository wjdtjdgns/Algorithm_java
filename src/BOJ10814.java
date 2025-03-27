import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            members[i] = new Member(input[1], Integer.parseInt(input[0]), i);
        }

        Arrays.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }

    static class Member implements Comparable<Member> {
        String name;
        int age;
        int order;

        public Member(String name, int age, int order) {
            this.name = name;
            this.age = age;
            this.order = order;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.order - o.order;
            }

            return this.age - o.age;
        }
    }
}
