package zajecia.czwarte;

import java.util.Scanner;

/**
 * Created by RENT on 2017-02-04.
 */
public class ZadaniaZeScannerem {

    public static void main(String[] args) {
//        scannerExample();
//        checkNumberFromUser();
//        listNumbersFromUserLessThan();
//        listEvenNumFromUserLessThan();

        // z uzyciem dwoch metod z roznymi argumentami
//        compareThreeNumbersFromUser();

//        int numberFromUser1 = getNumberFromUser();
//        int numberFromUser2 = getNumberFromUser("Podaj numer: ");

        /*
        int[] array = {3, 5, 0, 45, -4, 4, -4, -9};
        int minA = minArray(array);
        int maxA = maxArray(array);
        System.out.println("min: " + minA + " and max: " + maxA);
        */

//        System.out.println(getMin(3,4,5));

        /*
        System.out.println("Grade system.");
        double avg = avgOfGrades();
        System.out.println("Average of your grades is: " + avg);
        */

        calculator();

    }

    public static void calculator() {
        System.out.println("Insert 1 for sum");
        System.out.println("Insert 2 for subtraction");
        System.out.println("Insert 3 for multiplitation");
        System.out.println("Insert 4 for division");
        int operation = getNumberFromUser("Your choice:");

        if (operation > 0 && operation <=4) {
            int a = getNumberFromUser("Insert first number: ");
            int b = getNumberFromUser("Insert second number: ");

            if (operation == 1) {
                System.out.println("Result: " + (a+b));
            } else if (operation == 2) {
                System.out.println("Result: " + (a-b));
            } else if (operation == 3) {
                System.out.println("Result: " + (a*b));
            } else {
                if (b != 0) {
                    System.out.println("Result: " + (a / b));
                } else {
                    System.out.println("Don't divide by 0.");
                }
            }
        } else {
            System.out.println("Wrong data!");
        }


    }

    public static double avgOfGrades() {
        int size = getNumberFromUser("Insert number of your grades: ");
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = getNumberFromUser("Insert: " + (i + 1) + " grade: ");
        }
        double avg = Zajecia4.avgOfArrayElements(array);
        return avg;
    }

    public static int maxArray(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static int minArray(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void listEvenNumFromUserLessThan() {
        int number = getNumberFromUser();
        Zajecia4.printEvenLessThan(number);

    }

    public static void compareThreeNumbersFromUser() {
        int a = getNumberFromUser("Insert first number: ");
        int b = getNumberFromUser("Insert second number: ");
        int c = getNumberFromUser("Insert third number: ");
        System.out.println("Max: " + getMax(a, b, c));
        System.out.println("Min: " + getMin(a, b, c));
    }

    public static int getMax(int a, int b, int c) {
        int[] array = {a, b, c};
        return maxArray(array);
        /*
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
        */
    }

    public static int getMin(int a, int b, int c) {
        // wykorzystanie funkcji z tablica
        int[] array = {a, b, c};
        return minArray(array);
    }

    public static void listNumbersFromUserLessThan() {
        int number = getNumberFromUser();
        Zajecia4.printLessThan(number);

    }

    public static int getNumberFromUser() {
        return getNumberFromUser("Please insert your number: ");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Insert number: ");
//        return sc.nextInt();
    }

    public static int getNumberFromUser(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextInt();
    }

    public static void checkNumberFromUser() {
        int numberFromUser = getNumberFromUser();

        // metoda z innej klasy: Zajecia4.isEven()
        if (Zajecia4.isEven(numberFromUser)) {
            System.out.println("Your number is even");
        } else {
            System.out.println("Your number is odd");
        }
    }

    public static void scannerExample() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert your first name: ");
        String name = scanner.nextLine();
        System.out.println("Please insert your last name: ");
        String lastName = scanner.nextLine();
        String fullName = name + " " + lastName;

        System.out.println("Your name is: " + fullName);
    }

}

