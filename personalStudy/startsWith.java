
public class startsWith {
    public static void main(String[] args) {
        String text = "hello world";
        //특정 문자열이 접두사로 시작하는지 아닌지 확인

        //boolean result = "전체문자열".startsWith("시작하는지확인할문자열");
        boolean startWithhello = text.startsWith("hello"); //true
        boolean startWithWorld = text.startsWith("world"); //false, 문자열 시작 아님
        boolean startWithHello = text.startsWith("Hello"); //false, 대소문자 구별함

        //boolean result = "전체문자열".startsWith("확인할문자열", 시작위치);

        // text의 6번 인덱스부터 "World"로 시작하는지 확인
        // H e l l o   W o r l d
        // 0 1 2 3 4 5 6 7 8 9 10
        boolean checkFromMiddle = text.startsWith("World", 6); // true
        boolean checkFromWrongPlace = text.startsWith("Hello", 6); // false


        //세 번째 복습 완료!



    }

}
