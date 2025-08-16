import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static HashMap<Integer, Boolean> dfsVisited;
    private static HashMap<Integer, Boolean> bfsVisited;
    private static List<Integer> dfsList;
    private static List<Integer> bfsList;
    private static HashMap<Integer, List<Integer>> edges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        edges = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edges.putIfAbsent(key, new ArrayList<>());
            edges.putIfAbsent(value, new ArrayList<>());
            edges.get(key).add(value);
            edges.get(value).add(key);
        }

        // edges : {1=[2, 3, 4], 2=[4], 3=[4]}

        dfsVisited = new HashMap<>();
        dfsList = new ArrayList<>();
        dfs(V);
        System.out.println(dfsList.toString().replaceAll("[\\[\\],]", ""));

        bfsVisited = new HashMap<>();
        bfsList = new ArrayList<>();
        bfs(V);
        System.out.println(bfsList.toString().replaceAll("[\\[\\],]", ""));

    }

    private static void dfs(int vertex) {
        // 현재 방문한 정점을 방문 표시, dfsList에 추가
        dfsVisited.put(vertex, true);
        dfsList.add(vertex);

        // 현재 정점과 연결된 모든 정점을 순회
        List<Integer> neighbors = edges.get(vertex);
        if (neighbors != null) {
            Collections.sort(neighbors); // 오름차순 정렬 후 탐색
            for (int neighbor : neighbors) {
                if (!dfsVisited.containsKey(neighbor)) {
                    dfs(neighbor);
                }
            }
        }
    }

    // edges : {1=[2, 3, 4], 2=[4], 3=[4]}

    private static void bfs(int vertex) {
        // 현재 방문한 정점을 방문 표시, bfsList에 추가
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        bfsVisited.put(vertex, true);
        bfsList.add(vertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            List<Integer> neighbors = edges.get(currentVertex);
            if (neighbors != null) {
                Collections.sort(neighbors);
                for (int neighbor : neighbors) {
                    if (!bfsVisited.containsKey(neighbor)) {
                        bfsVisited.put(neighbor, true);
                        bfsList.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}