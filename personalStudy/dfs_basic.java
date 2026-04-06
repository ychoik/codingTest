import java.util.*;
import java.io.*;
public class dfs_basic {
    static int N,M;
    static boolean visited[][];
    static int [][] map;

    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

            if(!visited[nx][ny] && map[nx][ny]==1)
            {
                dfs(nx,ny);
            }

        }

    }

    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(!visited[i][j] && map[i][j]==1)
                {
                    dfs(i,j);
                    cnt++;
                }
            }
        }




    }
}
