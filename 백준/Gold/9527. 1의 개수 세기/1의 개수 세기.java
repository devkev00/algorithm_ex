import java.util.Scanner;

public class Main {

    public static long countOne(long num) {

        if (num <= 0) {
            return 0;
        }

        // 가장 큰 2^k 찾기
        long k = 0;
        while (1L << (k + 1) <= num) {
            k++;
        }

        // 재귀 호출 및 계산
        // 0 ~ 2 ^ (k - 1) - 1까지의 1의 개수: (k * 2 ^ (k -1))
        // << 왼쪽 쉬프트 연산자로 long 자료형을 다루면, 2의 제곱수를 아주 빠르게 구할 수 있음
        // 2 ^ 0 == 1이기 때문에 가능하다.
        return (k * (1L << (k - 1)) + (num - (1L << k) + 1) + countOne(num - (1L << k)));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        sc.close();

        long ans = 0;
        ans = countOne(B) - countOne(A - 1);

        System.out.println(ans);
    }
}