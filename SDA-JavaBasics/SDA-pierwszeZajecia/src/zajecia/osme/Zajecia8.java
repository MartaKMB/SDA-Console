package zajecia.osme;

import zajecia.siodme.Zajecia7;

/**
 * Created by RENT on 2017-02-09.
 */
public class Zajecia8 {
    public static void main(String[] args) {
        /*
        System.out.println(factorial(5));
        System.out.println(factorialRecursion(-4));
        System.out.println(fibonacciNumberRec(6));
        */

        /*
        String textToSwitch = "ABCdefGHIjkl";
        System.out.println(switchCaseWithBuilder(textToSwitch));
         */

        /*
        int sumNr = sumOfNumberDigits(1253);
        System.out.println(sumNr);
        */

        /*
        boolean alaTest1 = startsWith1("Ala ma kota", "Ala");
        boolean alaTest2 = startsWith2("Ala ma kota", "Ala");
        boolean alaTest3 = startsWith3("Ala ma kota", "Ala");
        System.out.println(alaTest3);
        */

    }

    public static boolean startsWith3 (String message, String expression) {
        char[] messageAsCharArray = message.toCharArray();
        char[] expressionAsCharArray = expression.toCharArray();
        boolean flag = true;
        for (int i = 0; i < expressionAsCharArray.length; i++) {
            if (messageAsCharArray[i] != expressionAsCharArray[i]) {
                flag = false;
            }
        }
        return flag;
     }

    /**
     * Can throw exception
     */
    public static boolean startsWith2 (String message, String expression) {
            String substringMessage = message.substring(0, expression.length());
            return substringMessage.equals(expression);
    }

    public static boolean startsWith1(String message, String expression){
        return message.startsWith(expression);
    }

    public static int sumOfNumberDigitsWithString(int number) {
        String numberAsString = String.valueOf(number);
        return Zajecia7.sumFromString(numberAsString);
    }

    public static int sumOfNumberDigits(int number) {
        int sum = 0;
        while(number != 0){
            int tmp = number % 10;
            sum += tmp;
            number /= 10;
        }
        return sum;
    }

    public static String switchCaseWithBuilder(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char tmp = message.charAt(i);
            if (tmp >= 65 && tmp <= 90) {
                stringBuilder.append((char) (tmp + 32));
            } else if (tmp >= 97 && tmp <= 122) {
                stringBuilder.append((char) (tmp - 32));
            } else {
                stringBuilder.append(tmp);
            }
        }
        return stringBuilder.toString();
    }

    public static String switchCase(String message) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 97 && charArray[i] <= 122) {
                charArray[i] -= 32;
            } else if (charArray[i] >= 65 && charArray[i] <= 90) {
                charArray[i] += 32;
            }
        }
        return String.valueOf(charArray);
    }

    public static int fibonacciNumberRec(int index) {
        if (index < 0) {
            return -1;
        }
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        return fibonacciNumberRec(index - 2) + fibonacciNumberRec(index - 1);
    }

    public static long factorialRecursion(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }
        return number * factorialRecursion(number - 1);
    }

    /**
     * return factorial from number
     * if wrong input (e.g. -5) then return -1
     */
    public static long factorial(int number) {
        long tmp = 1;
        for (int i = 2; i <= number; i++) {
            tmp *= i;
        }
        return tmp;
    }
}
