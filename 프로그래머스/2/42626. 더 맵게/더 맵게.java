import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue <Integer>pq = new PriorityQueue<>();

        for(int i=0; i< scoville.length; i++)
        {
            pq.offer(scoville[i]);
        }
        
        int p = 0;
        
        while(!pq.isEmpty() && pq.peek()<K)
        {
            if(pq.size() >= 2)
            {
                p= pq.poll()+(pq.poll()*2);
                pq.offer(p);
                answer++;
               
            }
            else if(pq.size()<2)
            {
                return -1;
                
            }
        }
        
        return answer;
    }
}