//올바른 괄호 문제
//프로그래머스 lv2 문제번호 12909

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            if(cnt<0)
            {
                answer=false;
                break;
            }

            if(c=='(')
            {
                cnt++;
            }
            else{
                cnt--;
            }

        }
        if(answer)
        {
            if(cnt!=0)
            {
                answer = false;
            }
        }
        return answer;
    }
}

public class true_12909 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()()"));
    }


}
