import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        String str = sc.next();

        char[] charArray = str.toCharArray();

        sc.close();

        int ans = 0;

        for (int i = 0; i < N; i++) {
            if (charArray[i] == 'P') { // 자바에서는 char을 담을 때는 ''을 쓴다. ""는 String 용이다.
                boolean alreadyEat = false;

                for (int j = Math.max(0, i - K); j < i; j++) { // 왼쪽부터 검사
                    if (charArray[j] == 'H') {
                        charArray[j] = 'h';
                        ans++;
                        alreadyEat = true;
                        break;
                    }
                }

                if (!alreadyEat) {
                    for (int k = i + 1; k < Math.min(N, i + K + 1); k++) { // 왼쪽에서 못 찾은 경우
                        if (charArray[k] == 'H') {
                            charArray[k] = 'h';
                            ans++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}