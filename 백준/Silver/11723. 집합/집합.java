import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
//
//    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
//    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
//    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
//    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
//    all: S를 {1, 2, ..., 20} 으로 바꾼다.
//    empty: S를 공집합으로 바꾼다.

//    첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.
//    둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.
//    check 연산이 주어질때마다, 결과를 출력한다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner보다 가벼움
        StringBuilder sb = new StringBuilder();
        // 문자열을 조작하기 편함

        int M = Integer.parseInt(br.readLine());

        Set<Integer> ansSet = new HashSet<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken(); // readLine의 첫 번째 토큰(문자열)을 읽어와서 할당

            int value = 0;

            if (st.hasMoreTokens()) { // st가 2 이상일 때, 즉 all or empty가 아닐 때만 value에 값을 할당
                value = Integer.parseInt(st.nextToken());
            }

            if (order.equals("add")) {
                ansSet.add(value);
            }

            if (order.equals("remove")) {
                ansSet.remove(value);
            }

            if (order.equals("check")) {
                if (ansSet.contains(value)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            if (order.equals("toggle")) {
                if (ansSet.contains(value)) {
                    ansSet.remove(value);
                } else {
                    ansSet.add(value);
                }
            }

            if (order.equals("all")) {
                ansSet.clear(); // 일단 비우고 추가
                for (int j = 1; j < 21; j++ ) {
                    ansSet.add(j);
                }
            }

            if (order.equals("empty")) {
                ansSet.clear();
            }
        }
        System.out.println(sb); // sout도 여러 번 호출하면 오버헤드가 커짐
    }
}