import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();

        List<Integer> sushiBelt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            sushiBelt.add(sc.nextInt());
        }

        // 원형 벨트를 위해 앞 k-1개 초밥을 뒤에 추가
        for (int i = 0; i < k - 1; i++) {
            sushiBelt.add(sushiBelt.get(i));
        }

        sc.close();

        // 초밥의 종류와 개수를 저장할 윈도우
        HashMap<Integer, Integer> sushiCountMap = new HashMap<>();

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            sushiCountMap.put(sushiBelt.get(i), sushiCountMap.getOrDefault(sushiBelt.get(i), 0) + 1);
            // 처음 나온 초밥이면 1로 설정, 기존에 있던 초밥이면 기존 개수(value) + 1
        }

        int maxKinds = sushiCountMap.size();
        if (!sushiCountMap.containsKey(c)) {
            maxKinds++; // 쿠폰 초밥이 포함 안 되어 있으면, 종류 +1
        }

        // 윈도우 움직이기
        for (int i = 1; i < N; i++) {
            // 왼쪽 끝 초밥 빼기
            int leftSushi = sushiBelt.get(i - 1);
            sushiCountMap.put(leftSushi, sushiCountMap.getOrDefault(leftSushi, 0) - 1);
            if (sushiCountMap.get(leftSushi) == 0) {
                sushiCountMap.remove(leftSushi); // 왼쪽에서 초밥이 하나 빠졌을 때 개수가 0이 되면, 종류가 하나 줄어드니까 key를 없애줌
            }

            // 오른쪽 초밥 더하기
            int rightSushi = sushiBelt.get(i + k - 1);
            sushiCountMap.put(rightSushi, sushiCountMap.getOrDefault(rightSushi, 0) + 1);

            // 현재 윈도우 초밥 종류 수 계산
            int currentKinds = sushiCountMap.size();

            if (!sushiCountMap.containsKey(c)) {
                currentKinds++; // 쿠폰 초밥이 포함 안 되어 있으면, 종류 +1
            }

            maxKinds = Math.max(maxKinds, currentKinds);
        }
        System.out.println(maxKinds);
    }
}