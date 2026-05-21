import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String arr[] = new String[numbers.length];
        
        for(int i=0; i<arr.length; i++)
        {
            arr[i] = numbers[i]+"";
        }
        
        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));// 두 문자열을 붙였을 때, 더 큰 값이 나오도록 정렬
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr)
        {
            sb.append(s);
        }
        
        return sb.toString();
    }
}