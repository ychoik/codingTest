import java.util.ArrayDeque;
import java.util.Deque;

public class stack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        if(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
