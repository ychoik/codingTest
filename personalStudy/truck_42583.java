import java.util.ArrayDeque;
import java.util.Deque;

public class truck_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();

        int total = 0;
        int time = 0;
        int i = 0;

        // 다리를 "칸"으로 만들기 (처음엔 전부 빈칸=0)
        for (int k = 0; k < bridge_length; k++) q.offer(0);

        while (i < truck_weights.length) {
            // 1초가 흐르면: 다리 맨 앞 칸이 빠짐(트럭이 나갈 수도, 0이 나갈 수도)
            total -= q.poll();

            // 이번 초에 새 트럭 올릴 수 있나?
            if (total + truck_weights[i] <= weight) {
                q.offer(truck_weights[i]);
                total += truck_weights[i];
                time++;
                i++;
            } else {
                // 못 올리면 빈칸(0) 넣고 다음 초로
                q.offer(0);
                time++;
                continue;
            }
        }

        // 마지막 트럭이 다리에서 빠져나가는 시간
        return time + bridge_length;
    }
    public static void main(String[] args) {
        truck_42583 solution = new truck_42583();
        System.out.println(solution.solution(2, 10, new int[]{7,4,5,6}));
    }
}
