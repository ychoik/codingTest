import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        int remain[] = new int[progresses.length];
        int days[] = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++)
        {
            remain [i] = 100-progresses[i];
            if(remain[i]%speeds[i]!=0)
            {
                days[i]=remain[i]/speeds[i]+1;
            }
            else{
                days[i]=remain[i]/speeds[i];
            }
        }
        //System.out.println(Arrays.toString(days));
        
        int str = days[0];//기준일
        int cnt=1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<days.length; i++)
        {
            if(days[i]<=str)
            {
                cnt++;
            }
            else{
                list.add(cnt);
                str=days[i];
                cnt=1;
            }
            
        }
        
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++)
        {
            answer[i]=list.get(i);
        }
        return answer;
    }
}