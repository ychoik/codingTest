public class split_toCharArray_diff {

    public static void main(String[] args) {

        String str = "Hello";
        //한 글자씩 string타입으로 잘라준다.
        String[] arr = str.split(""); // 빈 문자열 기준으로 나누기

        for(int i=0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }



        //한 글자씩 char 타입으로 잘라준다.
        char[] arr2 = str.toCharArray();

        for (char c : arr2) {
            System.out.println(c);
        }

    // 두 번째 복습 완료

    }
}
