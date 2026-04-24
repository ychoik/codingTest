import java.util.*;

// 우선순위 큐에 넣을 "정점 정보" 클래스
class Node implements Comparable<Node> {
    int to;     // 도착 정점 번호
    int cost;   // 시작점에서 이 정점까지 오는 현재 비용

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        // 비용(cost)이 작은 Node가 먼저 나오도록 설정
        // 즉, 우선순위 큐에서 "가장 짧은 거리"를 가진 정점이 먼저 나온다.
        return this.cost - o.cost;
    }
}

public class dijkstra_basic {
    static ArrayList<Node>[] graph; // 인접 리스트 그래프
    static int[] dist;              // 시작점에서 각 정점까지의 최단 거리 저장 배열

    public static void main(String[] args) {
        int n = 5; // 정점 개수 (1번 ~ 5번)

        // 그래프 배열 생성
        // graph[i]에는 i번 정점에서 갈 수 있는 정점들이 들어간다.
        graph = new ArrayList[n + 1];

        // 각 칸마다 ArrayList 생성
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 저장
        // 예: graph[1].add(new Node(2, 2));
        //     => 1번 정점에서 2번 정점으로 가는 비용이 2라는 뜻

        graph[1].add(new Node(2, 2)); // 1 -> 2 (비용 2)
        graph[1].add(new Node(3, 5)); // 1 -> 3 (비용 5)
        graph[2].add(new Node(3, 1)); // 2 -> 3 (비용 1)
        graph[2].add(new Node(4, 2)); // 2 -> 4 (비용 2)
        graph[3].add(new Node(4, 3)); // 3 -> 4 (비용 3)
        graph[3].add(new Node(5, 5)); // 3 -> 5 (비용 5)
        graph[4].add(new Node(5, 1)); // 4 -> 5 (비용 1)

        // 최단 거리 배열 생성
        dist = new int[n + 1];

        // 처음에는 모든 정점까지의 거리를 무한대라고 가정
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 1번 정점에서 시작하는 다익스트라 실행
        dijkstra(1);

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println("1번 -> " + i + "번 : " + dist[i]);
        }
    }

    static void dijkstra(int start) {
        // 우선순위 큐:
        // 현재까지 발견한 정점들 중에서
        // "비용이 가장 작은 정점"을 먼저 꺼내기 위해 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 정점까지의 거리는 0
        dist[start] = 0;

        // 시작 정점을 큐에 넣음
        pq.offer(new Node(start, 0));

        // 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            // 현재 가장 비용이 작은 정점을 꺼냄
            Node now = pq.poll();

            // now.to   = 현재 정점 번호
            // now.cost = 현재 정점까지 오는 비용

            // 이미 더 짧은 거리로 처리된 적이 있으면 무시
            // 예를 들어,
            // (3번, 비용 5)가 먼저 큐에 들어갔는데
            // 나중에 (3번, 비용 3)이 또 들어갈 수 있다.
            // 그럼 비용 5짜리가 나왔을 때는 무시해야 한다.
            if (now.cost > dist[now.to]) continue;

            // 현재 정점에서 갈 수 있는 다음 정점들을 확인
            for (Node next : graph[now.to]) {
                // next.to   = 다음 정점 번호
                // next.cost = 현재 정점 -> 다음 정점으로 가는 간선 비용

                // 시작점 -> 현재 정점까지 최단거리 + 현재 정점 -> 다음 정점 비용
                // = 시작점 -> 다음 정점으로 가는 새로운 후보 거리
                int newCost = dist[now.to] + next.cost;

                // 새로 계산한 거리가 기존 거리보다 더 짧다면 갱신
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;

                    // 갱신된 거리 정보를 우선순위 큐에 넣음
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}
