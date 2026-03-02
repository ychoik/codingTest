import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            
            if (phone_book[i].length() <= phone_book[i + 1].length() &&
                phone_book[i + 1].substring(0, phone_book[i].length()).equals(phone_book[i])) {
                return false; 
            }
        }
        
        return true; 
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean result = sol.solution(phone_book);
        
        
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        
        System.out.println(sb);
    }
}