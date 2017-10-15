package zajecia.siodme;

/**
 * Created by Muszka on 2017-02-09.
 */
public class HomeworkBrackets {
    public static void main(String[] args) {

        boolean check = checkBrackets("(1+1)*(2/3)+(4-3)-1");
        System.out.println(check);

    }
    public static boolean checkBrackets(String message) {
        char[] charArray = message.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 40) {
                sum++;
            } else if (charArray[i] == 41) {
                sum--;
                if (sum < 0) {
                    break;
                }
            }
        }
        return sum == 0;
    }

}
