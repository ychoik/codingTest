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
public class bfs_basic_2 {
    static int N, M;
    static int map[][];
    static boolean visited[][];
    static int [][] dist;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[]{x,y}); // 시작점을 큐에 넣는다.
        dist[x][y] =1;

        while(!q.isEmpty())
        {
            int current[] = q.poll();

            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<4; i++)
            {
                //다음에 이동할 좌표 계산
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

                if(map[nx][ny]==0) continue; // 벽이면 갈 수 없다.

                if(visited[nx][ny]){
                    continue;
                }

                visited[nx][ny] = true;

                dist[nx][ny] = dist[cx][cy]+1; // 다음 칸 까지의 거리 = 현재 칸까지의 거리 +1

                q.offer(new int[]{nx,ny});

            }

        }

    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int [M][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            String line = br.readLine();
            for(int j=0; j<M; j++)
            {
                map[i][j] = line.charAt(j)-'0';
            }
        }

        bfs(0,0);

    }
}
