
import java.util.*;
public class bfs_boj1012 {

    // 4방향 이동
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int X =0, Y =0;
        int input[][] = new int[M][N];

        Queue<Character> queue = new LinkedList<>();
        int[][] field = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 범위 체크(잘못된 값 들어오면 무시)
            if (x < 0 || x >= M || y < 0 || y >= N) {
                i--; // 잘못 입력된 건 다시 받기
                continue;
            }
            field[y][x] = 1;
        }

        int worms = 0; // 필요한 배추흰지렁이 수(= 연결요소 수)
        for (int r = 0; r < N; r++) {      // r: 행(y)
            for (int c = 0; c < M; c++) {  // c: 열(x)
                // 아직 방문하지 않은 배추(1)를 만나면 그 지점에서 BFS 시작
                if (field[r][c] == 1 && !visited[r][c]) {
                    bfs(field, visited, c, r, M, N);
                    worms++; // BFS 한 번은 하나의 덩어리를 모두 방문하므로 +1
                }
            }
        }

        // 각 테스트 케이스마다 결과를 한 줄에 출력
        out.append(worms).append('\n');

        // 모아서 한 번에 출력 (입출력 성능에 유리)
        System.out.print(out.toString());
    }






    static void bfs(int[][] field, boolean[][] visited, int sx, int sy, int M, int N) {
        List<int[]> array = new ArrayList<>();
        int head = 0; // 큐의 맨 앞을 가리키는 인덱스
        array.add(new int[] {sx, sy});
        visited[sy][sx] = true;

        while (head < array.size()) {           // isEmpty 대신 head 포인터 비교
            int[] cur = array.get(head++);      // poll() 대신 get(head++) 로 앞에서 꺼내기
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 1) 경계 체크
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[ny][nx]) continue;
                if (field[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                array.add(new int[]{nx, ny});   // offer() 대신 add()



            }
        }

    }

}
