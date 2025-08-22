import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr; // 수열을 저장할 배열
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//        길이가 M인 수열
//        사전 순 증가

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; // 수열을 담는 임시 리스트
        visited = new boolean[N + 1]; // 해당 숫자를 방문했는지 표시

        backtracking(0);
    }

    public static void backtracking(int index) {
        if (index == M) { // 길이 M인 수열을 완성
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return; // 백트래킹에서 return은 재귀를 멈추는 용도로 쓰임
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i + 1]) {
                arr[index] = i + 1;
                visited[i + 1] = true;
                backtracking(index + 1);
                visited[i + 1] = false;
            }
        }
    }
}