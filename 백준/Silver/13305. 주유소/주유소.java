import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 처음 주유소의 리터당 가격을 저장한다.
    // 이후 주유소의 리터당 가격을 비교하면서, 더 작은 경우에는 최신화하고 그 값에 거리를 곱해서 합산한다.
    // 아닌 경우 기존 값에 거리만 곱해서 합산한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer distances = new StringTokenizer(br.readLine()); // 거리
        StringTokenizer nodes = new StringTokenizer(br.readLine()); // 주유소

        long[] distancesArray = new long[N - 1];
        long[] nodesArray = new long[N];

        for (int i = 0; i < N - 1; i++) {
            distancesArray[i] = Long.parseLong(distances.nextToken());
            nodesArray[i] = Long.parseLong(nodes.nextToken());
        }

        long minPrice = nodesArray[0]; // 초기 기름값

        long minExpense = 0L;

        for (int i = 0; i < N - 1; i++) {
            if (nodesArray[i] < minPrice) {
                minPrice = nodesArray[i];
                minExpense += distancesArray[i] * minPrice;
            } else {
                minExpense += distancesArray[i] * minPrice;
            }
        }
        System.out.println(minExpense);
    }
}