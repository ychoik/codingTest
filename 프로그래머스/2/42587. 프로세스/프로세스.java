import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int []> q = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++)
        {
            q.offer(new int[]{priorities[i],i});
        }  
        
        while(!q.isEmpty())
        {
            int [] current = q.poll();
            boolean hasHigher = false;
            
            for(int [] process : q)
            {
                if(process[0]>current[0])
                {
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){
                q.offer(current);
            }
            else{
                answer++;
                
                if(current[1] == location){
                    return answer;
                }
            }
            
        }
        
        
        return answer;
    }
}