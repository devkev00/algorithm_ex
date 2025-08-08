
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void findMagicPrime(int number, int length) {
        if (length == N) {
            System.out.println(number);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            int nextNumber = number * 10 + i;
            if (isPrime(nextNumber)) {
                findMagicPrime(nextNumber, length + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        findMagicPrime(2, 1);
        findMagicPrime(3, 1);
        findMagicPrime(5, 1);
        findMagicPrime(7, 1);
    }
}