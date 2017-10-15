package zajecia.szoste;

import zajecia.czwarte.ZadaniaZeScannerem;

import java.util.Scanner;

/**
 * Created by RENT on 2017-02-07.
 */
public class Zajecia6 {
    public static void main(String[] args) {

        /*
        int sumCounter = sumUntil(15);
        System.out.println("You insert: " + sumCounter + " numbers until sum of your numbers was bigger than sum from computer.");
        */

//        calculator();

        /*
        String name = "Marta";
        System.out.println(name.indexOf('a'));
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        */

        /*
        char a = 'a';
        System.out.println(a);
        System.out.println((int)a);
        */

        System.out.println("Encoded text: ");
        String war = cezarCode("Wojna");
        System.out.println(war);
        String hello = cezarCode("Hello World", 3);
        System.out.println(hello);

        System.out.println();
        System.out.println("Decoded:" );
        System.out.println(decodeCezarCode(war));
        System.out.println(decodeCezarCode(hello, 3));

    }

    public static String decodeCezarCode(String coddedMessage) {
        return cezarCode(coddedMessage, -1);
    }

    public static String decodeCezarCode(String coddedMessage, int coddedKey) {
        return cezarCode(coddedMessage, -coddedKey);
    }

    public static String cezarCode(String message) {
        return cezarCode(message, 1);
    }

    public static String cezarCode(String message, int key) {
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
//            charArray[i]++;
            charArray[i] = (char)(charArray[i] + key);
        }
        return String.valueOf(charArray);
    }

    public static void calculator() {
        boolean flag = true;
        while (flag) {
            System.out.println("Insert 1 for sum");
            System.out.println("Insert 2 for subtraction");
            System.out.println("Insert 3 for multiplitation");
            System.out.println("Insert 4 for division");
            System.out.println("Insert 0 for end");
            int nrChoice = ZadaniaZeScannerem.getNumberFromUser("Your choice:");
            int firstNrFromUser = 0;
            int secondNrFromUser = 0;
            if (nrChoice>0 && nrChoice <5) {
                firstNrFromUser = ZadaniaZeScannerem.getNumberFromUser("Insert first number: ");
                secondNrFromUser = ZadaniaZeScannerem.getNumberFromUser("Insert second number: ");
            }
            switch (nrChoice) {
                case 1:
                    System.out.println(firstNrFromUser + " + " + secondNrFromUser + " = " + (firstNrFromUser + secondNrFromUser));
                    break;
                case 2:
                    System.out.println(firstNrFromUser + " - " + secondNrFromUser + " = " + (firstNrFromUser - secondNrFromUser));
                    break;
                case 3:
                    System.out.println(firstNrFromUser + " * " + secondNrFromUser + " = " + (firstNrFromUser * secondNrFromUser));
                    break;
                case 4:
                    if (secondNrFromUser != 0) {
                        System.out.println(firstNrFromUser + " / " + secondNrFromUser + " = " + (firstNrFromUser / secondNrFromUser));
                    } else {
                        System.out.println("Don't divide by 0.");
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong data");
                    break;
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static int avgUntil(int avg) {
        int counter = 0;
        int sumFromUser = 0;
        boolean flag = true;
        while (flag) {
            int nrFromUser = ZadaniaZeScannerem.getNumberFromUser();
            sumFromUser += nrFromUser;
            counter++;
            double avgNrFromUser = (double) sumFromUser / counter;
            System.out.println("Temporary avg numbers from user is: " + avgNrFromUser);
            if (avgNrFromUser > avg) {
                flag = false;
            }
        }
        return counter;
    }

    public static int sumUntil(int sum) {
        int counter = 0;
        int sumFromUser = 0;
        boolean flag = true;
        while (flag) {
            int nrFromUser = ZadaniaZeScannerem.getNumberFromUser();
            counter++;
            sumFromUser += nrFromUser;
            System.out.println("Temporary sum from user: " + sumFromUser);
            if (sumFromUser > sum) {
                flag = false;
            }
        }
        return counter;
    }
}
