import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물품의 수
        int K = sc.nextInt(); // 들 수 있는 무게

        int[] weights = new int[N];
        int[] values = new int[N];

        // 물품 정보 입력 받기
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        sc.close();

        // 포인트: 배낭의 무게를 꼭 다 채우는 것이 최대 가치를 보장하지 않음
        // dp 테이블을 만들고, 각 무게 별 최대 가치를 저장해서 최댓값을 반환하면 됨.

        int[] dp = new int[K + 1]; // 0 ~ k

        for (int i = 0; i < N; i++) {
            int currentWeight = weights[i];
            int currentValue = values[i];

             for (int w = K; w >= currentWeight; w--) {
                 dp[w] = Math.max(dp[w], dp[w - currentWeight] + currentValue);
             }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[K]);
    }
}
