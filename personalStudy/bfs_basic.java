/*
2. BFS 문제
문제: 미로에서 최단 거리 구하기

N x M 크기의 미로가 주어진다.
각 칸은 다음 의미를 가진다.

1 : 이동 가능
0 : 벽

시작점은 (0, 0)이고 도착점은 (N-1, M-1)이다.
상하좌우로만 이동할 수 있을 때,
시작점에서 도착점까지 가는 최단 거리를 구하시오.

단, 시작 칸과 도착 칸도 거리 계산에 포함한다.

입력 예시
5 6
101111
101010
101011
111011
000011
출력 예시
10
 */

import java.util.*;
import java.io.*;

public class bfs_basic {
    // 미로의 세로 크기(N), 가로 크기(M)
    static int N, M;

    // 미로 정보 저장 배열
    // 1 = 이동 가능
    // 0 = 벽
    static int[][] map;

    // 시작점 (0,0)에서 각 칸까지의 최단 거리를 저장하는 배열
    static int[][] dist;

    // 방문 여부를 저장하는 배열
    // true  = 이미 방문한 칸
    // false = 아직 방문하지 않은 칸
    static boolean[][] visited;

    // 상, 하, 좌, 우 이동을 위한 배열
    // 예를 들어 현재 위치가 (x, y)일 때
    // i=0 -> (x-1, y) : 위
    // i=1 -> (x+1, y) : 아래
    // i=2 -> (x, y-1) : 왼쪽
    // i=3 -> (x, y+1) : 오른쪽
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // BFS 함수
    // 시작 좌표 (x, y)부터 탐색을 시작해서
    // 갈 수 있는 모든 칸까지의 최단 거리를 dist 배열에 저장한다.
    public static void bfs(int x, int y) {

        // BFS는 큐를 사용한다.
        // 큐에는 "앞으로 탐색할 좌표"를 넣는다.
        Queue<int[]> queue = new ArrayDeque<>();

        // 시작점을 큐에 넣는다.
        // int[]{x, y} 형태로 좌표를 저장
        queue.offer(new int[]{x, y});

        // 시작점은 방문 처리
        visited[x][y] = true;

        // 시작 칸의 거리 = 1
        // (문제 조건에 따라 시작 칸도 거리 포함)
        dist[x][y] = 1;

        // 큐가 빌 때까지 반복
        // 즉, 탐색해야 할 칸이 남아 있는 동안 계속 진행
        while (!queue.isEmpty()) {

            // 큐의 맨 앞 좌표를 꺼낸다.
            // BFS는 먼저 들어간 좌표를 먼저 꺼내므로
            // 가까운 칸부터 차례대로 탐색할 수 있다.
            int[] current = queue.poll();

            // 현재 좌표를 각각 꺼내기
            int cx = current[0];
            int cy = current[1];

            // 현재 위치에서 상하좌우 4방향을 확인
            for (int i = 0; i < 4; i++) {

                // 다음에 이동할 좌표 계산
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 1. 배열 범위를 벗어나면 무시
                // 예: x가 -1이 되거나, N 이상이 되면 map 밖임
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                // 2. 벽(0)이면 갈 수 없으므로 무시
                if (map[nx][ny] == 0) {
                    continue;
                }

                // 3. 이미 방문한 칸이면 다시 갈 필요가 없으므로 무시
                // BFS에서는 처음 방문한 경로가 최단 거리이기 때문
                if (visited[nx][ny]) {
                    continue;
                }

                // 여기까지 왔다는 뜻은:
                // - 범위 안이고
                // - 벽이 아니고
                // - 아직 방문하지 않은 칸이라는 뜻

                // 다음 칸 방문 처리
                visited[nx][ny] = true;

                // 다음 칸까지의 거리 = 현재 칸까지의 거리 + 1
                // 왜냐하면 현재 칸에서 한 칸 더 이동했기 때문
                dist[nx][ny] = dist[cx][cy] + 1;

                // 다음 칸도 나중에 기준점이 되어 주변을 탐색해야 하므로
                // 큐에 넣어준다.
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력: N M
        // 예: 5 6
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로 크기 N
        N = Integer.parseInt(st.nextToken());

        // 가로 크기 M
        M = Integer.parseInt(st.nextToken());

        // 배열들 생성
        map = new int[N][M];         // 미로 정보
        dist = new int[N][M];        // 최단 거리 저장
        visited = new boolean[N][M]; // 방문 여부 저장

        // 미로 입력 받기
        // 예를 들어 한 줄이 "101111"처럼 들어온다면
        // 공백이 없기 때문에 StringTokenizer를 쓰지 않고
        // 문자열 한 줄을 그대로 받은 뒤 charAt으로 한 글자씩 꺼낸다.
        for (int i = 0; i < N; i++) {

            // 한 줄 입력 받기
            String line = br.readLine();

            // 문자열의 각 문자를 숫자로 바꿔 map에 저장
            for (int j = 0; j < M; j++) {

                // line.charAt(j)는 문자 '0' 또는 '1'
                // 여기에 '0'을 빼주면 실제 숫자 0 또는 1이 된다.
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 시작점 (0,0)에서 BFS 시작
        bfs(0, 0);

        // 도착점 (N-1, M-1)까지의 최단 거리 출력
        System.out.println(dist[N - 1][M - 1]);
    }
}
