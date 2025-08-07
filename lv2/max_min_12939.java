import java.util.*;
//프로그래머스 lv2 문제번호: 12939
public class max_min_12939 {
    public String solution(String s) {
        String [] parts = s.split(" ");
        int nums[] = new int[parts.length];
        for(int i=0; i<parts.length; i++)
        {
            nums[i]=Integer.parseInt(parts[i]);
        }
        Arrays.sort(nums);

        String answer = nums[0]+" "+nums[nums.length-1];

        return answer;
    }
}
