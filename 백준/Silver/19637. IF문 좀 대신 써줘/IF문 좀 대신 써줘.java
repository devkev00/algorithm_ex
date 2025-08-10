import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 칭호의 개수
        int M = Integer.parseInt(st.nextToken()); // 칭호 출력 캐릭 개수

        String[] titleList = new String[N];
        long[] attackList = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titleList[i] = st.nextToken();
            attackList[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            long attackPoint = Long.parseLong(br.readLine());

            // 이진 탐색
            int left = 0;
            int right = N - 1;
            String resultTitle = "";

            // 칭호 리스트와 공격력 리스트의 idx는 동일하다는 점을 이용한다.
            while (left <= right) {
                int mid = (left + right) / 2;

                if (attackList[mid] >= attackPoint) {
                    resultTitle = titleList[mid];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(resultTitle).append("\n");
        }
        System.out.println(sb.toString());
    }
}