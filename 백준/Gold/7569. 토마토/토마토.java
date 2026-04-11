import java.util.*;
import java.io.*;

public class Main {
    static int N, M, H;
    static int[][][] map;
    static Queue<int[]> q;

    static void bfs() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int h = now[0];
            int x = now[1];
            int y = now[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nh < 0 || nh >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nh][nx][ny] == 0) {
                    map[nh][nx][ny] = map[h][x][y] + 1;
                    q.offer(new int[]{nh, nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 문제 입력 순서: M N H
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        q = new ArrayDeque<>();

        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    map[h][x][y] = Integer.parseInt(st.nextToken());

                    if (map[h][x][y] == 1) {
                        q.offer(new int[]{h, x, y});
                    }
                }
            }
        }

        bfs();

        int max = 0;

        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (map[h][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[h][x][y]);
                }
            }
        }

        System.out.println(max - 1);
    }
}