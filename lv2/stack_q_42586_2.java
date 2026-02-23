import java.util.*;


//프로그래머스 고득점 kit 기능개발 lv2 다른 풀이
public class stack_q_42586_2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i< speeds.length; i++){
            double remain = (100-progresses[i])/(double)speeds[i];
            int date = (int) Math.ceil(remain);//Math.ceil은 올림 함수

            if(!q.isEmpty() && q.peek() < date){
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);

        }

        answerList.add(q.size());

        int [] answer = new int[answerList.size()];

        for(int i=0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;


    }

    public static void main(String[] args) {
        stack_q_42586 sol = new stack_q_42586();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = sol.solution(progresses, speeds);
        System.out.println(Arrays.toString(result)); // [2, 1]
    }

}
