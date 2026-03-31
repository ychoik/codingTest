import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        
        
        for(int idx=0; idx<commands.length; idx++)
        {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int l = commands[idx][2];
            
            int temp[] = new int [j-i+1];
           
            int cnt=0;
            for(int k=i-1; k<j; k++)
            {
                temp[cnt] = array[k];
                cnt++;
            }
            Arrays.sort(temp);
            answer[idx] = temp[l-1];
            //System.out.println(Arrays.toString(temp));
            
        }
        
        return answer;
    }
}