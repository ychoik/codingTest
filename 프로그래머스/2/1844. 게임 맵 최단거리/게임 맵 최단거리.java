import java.util.*;
class Solution {
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int [][] dist = new int [n][m]; // 방문했으면 1
        
        dist[0][0]=1;
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty())
        {
            int [] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            if(x==n-1 && y == m-1)
            {
                return dist[x][y];
            }
            
            for(int i=0; i<4; i++)
            {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                
                
                if(nx<0 || nx>=n || ny<0 || ny>=m)
                {
                    continue;
                }
                if(maps[nx][ny]==0)
                {
                    continue;
                }
                if(dist[nx][ny]!=0)
                {
                    continue;
                }
                
                dist[nx][ny] = dist[x][y]+1;
                q.offer(new int[]{nx,ny});
            }
            
        }
        
        
        return -1;
    }
}