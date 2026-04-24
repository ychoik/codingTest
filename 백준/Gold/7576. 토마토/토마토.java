import java.io.*;
import java.util.*;

public class Main {

    // M = 가로 칸 수, N = 세로 칸 수
    static int M, N;

   
    static int[][] box;

    // 상, 하, 좌, 우 이동을 위한 배열
    // 예: 현재 위치가 (x, y)일 때
    // 위쪽은 (x-1, y)
    // 아래쪽은 (x+1, y)
    // 왼쪽은 (x, y-1)
    // 오른쪽은 (x, y+1)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        
        box = new int[N][M];

        // BFS에 사용할 큐
        // int[] 하나에 {행, 열} 저장
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 익지 않은 토마토 개수를 세기 위한 변수
        int unripeCount = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                
                // BFS의 시작점이 될 수 있으므로 큐에 넣어둔다.
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }

                // 개수를 하나 증가시킨다.
                if (box[i][j] == 0) {
                    unripeCount++;
                }
            }
        }

        // 익지 않은 토마토가 애초에 하나도 없다면
        // 이미 다 익어 있는 상태이므로 0 출력
        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        bfs(queue);

        // BFS가 끝난 뒤 결과 확인용
        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 아직도 0이 남아 있다면
                // 끝까지 익지 못한 토마토가 있다는 뜻
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                // 가장 큰 숫자를 찾는다.
                // 이 값이 가장 늦게 익은 날짜 정보가 된다.
                if (box[i][j] > maxDay) {
                    maxDay = box[i][j];
                }
            }
        }

        // 실제 날짜는 0일부터 시작해야 하므로 1을 빼준다.
        System.out.println(maxDay - 1);
    }

    static void bfs(ArrayDeque<int[]> queue) {
        
        while (!queue.isEmpty()) {

            // 현재 위치 꺼내기
            int[] current = queue.poll();

            int x = current[0]; 
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 아직 익지 않은 토마토(0)라면
                // 현재 토마토의 다음 날짜로 익게 만든다.
                if (box[nx][ny] == 0) {
                    box[nx][ny] = box[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
