import java.util.*;
import java.io.*;

public class bfs_basic {
    static int N,M;
    static boolean[][] visited;
    static int [][] map;
    static int [][] dist;

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void bfs(int x, int y){
        Queue<int[]>q = new ArrayDeque<>();
        q.offer(new int []{x,y});

        visited[x][y]=true;
        dist[x][y]=1;

        while(!q.isEmpty())
        {
            int [] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<4; i++)
            {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx<0 ||nx>=N || ny<0 || ny>=M)
                {
                    continue;
                }

                if(map[nx][ny] == 0) continue; //벽이면 못 감
                if(visited[nx][ny]) continue;

                visited[nx][ny]=true;
                dist[nx][ny]=dist[cx][cy]+1;
                q.offer(new int[]{nx,ny});

            }
        }
    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][M];
        dist = new int[N][M];
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
