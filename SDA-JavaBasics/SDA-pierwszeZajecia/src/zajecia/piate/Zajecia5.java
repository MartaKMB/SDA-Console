package zajecia.piate;

import zajecia.czwarte.ZadaniaZeScannerem;

import java.util.Random;

/**
 * Created by RENT on 2017-02-06.
 */
public class Zajecia5 {

    public static void main(String[] args) {
        /*
        int number = ZadaniaZeScannerem.getNumberFromUser();
        evenMatrix(number);
        */

        /*
        Random random = new Random();

        int stepsToWin = game(random.nextInt(100));
        System.out.println("End of game");
        System.out.println("You win in: " + stepsToWin + " step/s.");
        */

        int[] orderedArray = countPresensHomework();
        printHomework(orderedArray);


    }

    // homework
    public static int[] countPresensHomework() {
        int[] array = new int[10];
        boolean flag = true;
        while (flag) {
            int nrFromUser = ZadaniaZeScannerem.getNumberFromUser();
            if (nrFromUser >= 0 && nrFromUser <= 9) {
                array[nrFromUser]++;
            } else {
                flag = false;
            }
        }
        return array;
    }

    public static void printHomework (int[] orderedArray) {
        for (int i = 0; i < orderedArray.length; i++) {
            for (int j = 0; j < orderedArray[i]; j++) {
                System.out.println(i);
            }
        }
    }

    public static int game(int number) {
        boolean flag = true;
        int counter = 0;
        while (flag) {
            int nrFromUser = ZadaniaZeScannerem.getNumberFromUser();
            counter++;
            if (nrFromUser == number) {
                flag = false;
            } else if (nrFromUser > number) {
                System.out.println("Your number: " + nrFromUser + " is too big");
            } else {
                System.out.println("Your number: " + nrFromUser + " is too small");
            }
        }
        return counter;
    }

    public static int[] arrayOfNumbersFromUser() {
        int[] tmpArray = new int[100];
        int size = 0;
        boolean flag = true;
        while (flag) {
            int nrFromUser = ZadaniaZeScannerem.getNumberFromUser();
            if (nrFromUser != 0) {
                tmpArray[size] = nrFromUser;
                size++;
            } else {
                flag = false;
            }
        }
        return revriteArray(tmpArray, size);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] revriteArray(int[] bigArray, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = bigArray[i];
        }
        return array;
    }

    public static int sumOfNumbersFromUser() {
        int sum = 0;
        boolean flag = true;
        while (flag) {
            int nrFromUser = ZadaniaZeScannerem.getNumberFromUser("Insert next number: ");
            if (nrFromUser != 0) {
                sum += nrFromUser;
            } else {
                flag = false;
            }
        }
        return sum;
    }

    public static void evenMatrix(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    public static void oneMatrix(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i == j) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void traingle(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void square(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void tree(int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < ((number - i) - 1); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < ((i * 2) + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int m = 0; m < number; m++) {
            for (int n = 0; n < (number - 1); n++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}
