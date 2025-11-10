//https://www.acmicpc.net/problem/1012


import java.util.*;
public class bfs_boj1012_2 {

    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = sc.nextInt(); // 테스트 개수

        while(T-->0) {
            int M = sc.nextInt();//배추밭의 가로
            int N = sc.nextInt();//배추밭의 세로
            int K = sc.nextInt();//배추가 심어져 있는 위치의 개수

            int x = 0, y = 0; //배추의 위치

            int[][] field = new int[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                x = sc.nextInt();//(0<x<M-1)
                y = sc.nextInt();//(0<Y<N-1)

                if (x < 0 || y < 0 || x >= M || y >= N) {
                    i--;
                    continue;
                }
                field[y][x] = 1;

            }

            int worms = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(field, visited, j, i, M, N);
                        worms++;
                    }
                }
            }

            out.append(worms).append('\n');
        }
        System.out.print(out.toString());
    }
    public static void bfs(int [][] field, boolean[][] visited, int sx, int sy,  int M, int N)
    {
        List<int []>array = new ArrayList<>();
        int head=0;
        array.add(new int[]{sx,sy});
        visited[sy][sx]=true;

        while(head<array.size())
        {
            int cur [] = array.get(head++);
            int x=cur[0];
            int y=cur[1];

            for(int d=0; d<4; d++)
            {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(visited[ny][nx]) continue;
                if(field[ny][nx]==0) continue;

                visited[ny][nx]=true;
                array.add(new int[]{nx,ny});
            }

        }


    }

}
