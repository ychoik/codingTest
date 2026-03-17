import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String initial = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(int i=0; i< initial.length(); i++)
        {
            left.addLast(initial.charAt(i));
        }

        for(int i=0; i<m; i++)
        {
            String command = br.readLine();

            char c = command.charAt(0);

            if(c == 'L')
            {
                if(!left.isEmpty())
                {
                    right.addLast(left.removeLast());
                }

            } else if(c=='D')
            {
                if(!right.isEmpty())
                {
                    left.addLast(right.removeLast());
                }
            } else if(c == 'B')
            {
                if(!left.isEmpty())
                {
                    left.removeLast();
                }
            } else if(c == 'P')
            {
                char ch = command.charAt(2);
                left.addLast(ch);
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()){
            sb.append(left.removeFirst());
        }

        while(!right.isEmpty()){
            sb.append(right.removeLast());
        }

        System.out.println(sb);
    }
}