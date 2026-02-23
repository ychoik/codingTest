import java.util.ArrayDeque;
import java.util.Deque;
//이거 활용해서 bfs 문제풀이 가능
public class queue {
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();


        q.offer(10);
        q.offer(20);
        q.offer(30);


        System.out.println(q.peek());

        System.out.println(q.poll());
        System.out.println(q.poll());

    }
}
