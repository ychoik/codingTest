import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int [][] dist = new int[n][m]; //최단거리니까 dist 총 합이 최소여야 함.
        dist[0][0]=1; 
        Queue<int[]> q = new ArrayDeque<>(); //어떻게 1차원 배열을 생각했지? 나는 2차원 배열 생각했는데
        
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty())
        {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            if(x==n-1 && y==m-1)
            {
                return dist[x][y];
            }
            
            for(int i=0; i<4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx<0 || nx>=n || ny<0 || ny>=m)
                {
                    continue;
                }
                if(maps[nx][ny]==0){
                    continue;
                }
                if(dist[nx][ny]!=0)
                {
                    continue;
                }
                dist[nx][ny]=dist[x][y]+1;
                q.offer(new int[]{nx,ny});
            }
            
        }
        
        
        return -1;
    }
}