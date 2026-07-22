import java.util.*;
class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) //0번부터 n-1번 컴퓨터까지 확인
        {
            if(!visited[i]){//아직 방문하지 않았다면, 새로운 컴퓨터라는 의미
                answer++;
                bfs(i, n, computers, visited);
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, int n, int[][] computers, boolean[] visited){
                
        Deque<Integer> q = new ArrayDeque<>();
        visited[start]=true;//시작점 방문처리
        q.offer(start);//시작점 q에 담기
        
        while(!q.isEmpty())//q에 데이터가 있으면
        {
            int current =q.poll(); //뽑아서 current에 저장
            for(int next=0; next<n; next++)
            {
                if(computers[current][next]==1 && !visited[next]){//아직 방문하지 않았으면
                    visited[next]=true; //방문기록 추가
                    q.offer(next);//q에 해당 위치 추가
                }
            }
            
        }
        
        
    }
}