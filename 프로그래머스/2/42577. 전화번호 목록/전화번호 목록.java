import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book); //사전 순으로 정렬   
        
        for(int i=0; i<phone_book.length-1; i++)
        {
            if(phone_book[i+1].startsWith(phone_book[i]))
            {
                return false;
            }
        }
        
        return answer;
    }
}