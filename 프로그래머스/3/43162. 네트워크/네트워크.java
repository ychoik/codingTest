import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            if(!visited[i]){
                answer++;
                bfs(i, n, computers, visited);
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, int n, int[][] computers, boolean[] visited){
                
        Deque<Integer> q = new ArrayDeque<>();
        visited[start]=true;
        q.offer(start);
        
        while(!q.isEmpty())
        {
            int current =q.poll();
            for(int next=0; next<n; next++)
            {
                if(computers[current][next]==1 && !visited[next]){
                    visited[next]=true;
                    q.offer(next);
                }
            }
            
        }
        
        
    }
}