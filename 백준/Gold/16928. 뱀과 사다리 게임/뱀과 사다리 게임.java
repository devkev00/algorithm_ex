import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> boardMap = new HashMap<>();
        // 뱀과 사다리 정보를 추가함
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            boardMap.put(start, end);
        }

        int[] count = new int[101]; // 각 칸 별 최소 굴림 횟수
        boolean[] visited = new boolean[101]; // 각 칸 별 방문 여부

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        count[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 100) {
                System.out.println(count[100]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = current + i;

                if (next > 100) {
                    continue;
                }

                int finalPosition = next;

                if (boardMap.containsKey(next)) {
                    finalPosition = boardMap.get(next);
                }

                if (!visited[finalPosition]) { // 처음 방문하는 칸만 큐에 추가
                    visited[finalPosition] = true;
                    count[finalPosition] = count[current] + 1;
                    queue.add(finalPosition);
                }
            }
        }
    }
}