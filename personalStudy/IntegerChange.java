
//String을 int형으로 변환하는 방법  예시.
public class IntegerChange {
    public static void main(String[] args) {
        String input = "1-2+3+4";
        int in[] = new int[input.length() / 2 + 1];
        String sign[] = new String[input.length() / 2];
        int in_index = 0;
        int sign_index = 0;

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                in[in_index] = Integer.parseInt(String.valueOf(input.charAt(i)));
                //in[in_index]=input.chatAt(i)-'0';
                in_index++;

            } else {
                sign[sign_index] = input.charAt(i) + "";
                sign_index++;
            }
        }
    }
}
