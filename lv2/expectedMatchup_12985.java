
class Solution_12985{
    public int solution(int n, int a, int b) {
        int answer = 0;

        for(int i = 1; ; i++){
            a = (a + 1) / 2;
            b = (b + 1) / 2;

            if(a==b)
            {
                answer=i;
                break;
            }
        }

        return answer;
    }
}


public class expectedMatchup_12985 {
    public static void main(String[] args) {
        Solution_12985 sol = new Solution_12985();
        System.out.println(sol.solution(8,4,7));

    }


}
