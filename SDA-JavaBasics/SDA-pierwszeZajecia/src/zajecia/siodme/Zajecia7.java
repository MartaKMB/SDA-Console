package zajecia.siodme;

import java.util.Random;

/**
 * Created by RENT on 2017-02-08.
 */
public class Zajecia7 {
    public static void main(String[] args) {

        /*
        String randomString = randomLowerCase(105);
        int[] orderedArray = stringStatistics(randomString);
        printStatistic(orderedArray);
        */

        /*
        String ala = "Ala_ma_kota";
        String convert = convertSpaces(ala);
        System.out.println(convert);
        */

        /*
        String ToReverse = "Hakuna Matata";
        String reverse = reverseString(ToReverse);
        System.out.println(reverse);
        */

        int sum = sumFromString("Marta has 1 cat and 2 dogs");
        System.out.println("Marta has: " + sum + " animals");
    }


    public static int sumFromString(String message) {
        char[] charArray = message.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length ; i++) {
            if (charArray[i] >= 48 && charArray[i] <= 57) {
                int findNumber = charArray[i] - 48;
                sum += findNumber;
            }
        }
        return sum;
    }

    public static boolean isPalindrome (String message) {
        // return message == reverseString(message)
        // ale jak już po pierwszych wiemy, ze to nie palindrom bez sensu przejść po wszystkich
        boolean flag = true;
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                flag = false;
                break;
            }
        }
        return flag;
        // lepiej jak jest jeden return,
        // ale moze tez byc return false i return true bez deklaracji boolean
    }

    public static String reverseString(String message) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char tmp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = tmp;
        }
        return String.valueOf(charArray);
    }

    public static String convertSpaces(String message) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 95) {
//                charArray[i] = ' ';
                charArray[i] = (char) 32;
            }
        }
        return String.valueOf(charArray);
    }

    public static String randomLowerCase(int size) {

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size ; i++) {
            int generetedValue = random.nextInt(26) + 97;
            stringBuilder.append((char) generetedValue);
        }
        return stringBuilder.toString();

        // metody ponizej sa ok i dzialaja, ale zajmuja duzo pamieci - powyzej poprawne
        /*
        Random random = new Random();
        String tmpMessage = "";
        for (int i = 0; i < size; i++) {
            int generetedValue = random.nextInt(26) + 97;
            String generetedValueAsString = String.valueOf((char)(generetedValue));
            tmpMessage += generetedValueAsString;
        }
        return tmpMessage;
        */

        // tworzenie tablicy ze znakami a pozniej jeszcze pamiec na Stringa
        /*
        Random random = new Random();
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            int generetedValue = random.nextInt(26) + 97;
            chars[i] = (char)generetedValue;
        }
        return String.valueOf(chars);
        */
    }

    public static void printStatistic (int[] orderedArray) {
        for (int i = 0; i < orderedArray.length; i++) {
            for (int j = 0; j < orderedArray[i]; j++) {
                char znak = (char)(i+97);
                System.out.print(znak);
            }

        }
    }

    public static int[] stringStatistics (String message) {
        int[] statisticArray = new int[26];
        char[] charArray = message.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] >= 97 && charArray[1] <= 122) {
                    int index = charArray[i] - 97;
                    statisticArray[index]++;
                }
        } return statisticArray;
    }

}
