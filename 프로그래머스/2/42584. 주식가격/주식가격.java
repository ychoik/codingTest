import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<prices.length; i++)
        {
            q.offer(prices[i]);
        }
        
        int index=0;
        
        while(!q.isEmpty())
        {
            int currentPrice = q.poll();
            int cnt=0;
            
            for(int next:q)
            {
                cnt++;
                if(currentPrice > next)
                {
                    break;
                }
                
            }
            answer[index]=cnt;
            index++;
            
            
        }
        
        
        return answer;
        
    }
}