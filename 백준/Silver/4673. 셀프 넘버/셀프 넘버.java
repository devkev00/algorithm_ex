import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 셀프 넘버

        // 1부터 10000까지 담겨 있는 리스트 생성
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        // 10000 이하의 생성자들만 담는 리스트 생성
        ArrayList<Integer> generators = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            int generator = generate(i);
            if (generator <= 10000) {
                generators.add(generator);
            }
        }
        // numbers에서 generators를 제외하고 출력
        numbers.removeAll(generators);
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
    // 생성자를 만드는 메서드
    public static int generate(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}