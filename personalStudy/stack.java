import java.util.ArrayDeque;
import java.util.Deque;

//닫는 괄호를 만났을 때 스택 맨 위가 짝인지 확인하는 문제.
//스택 pop 할 때는  isEmpty 항상 생각하기

public class stack {
    static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray())
        {
            if(ch =='(')
            {
                stack.push(ch);
            }
            else if(ch==')')
            {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("()()")); // true
        System.out.println(isValid("(())")); // true
        System.out.println(isValid("(()"));  // false
        System.out.println(isValid("())"));  // false

    }
}
