package zajecia;

import java.util.Scanner;

public class Zajecia2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your first name");
        String firstName = scanner.nextLine();
        System.out.println("Insert your last name");
        String lastName = scanner.nextLine();
        System.out.println("Insert your age");
        int age = scanner.nextInt();

        System.out.print("Your are ");
        System.out.println(firstName + " " + lastName);
        System.out.print("Your age is ");
        System.out.print(age);

        //1. pytamy o liczbe scanner.nextInt
        //2. sprawdzamy czy jest parzysta
        //3 jezeli jest parzysta, to informacja
        //4
    }

    public static int numberOfOdd(int[] array) {
        return array.length - numberOfEven(array);
    }

    public static int numberOfEven(int[] array) {
        int counter = 0;
        for (int i = 0 ; i < array.length ; i++) {
            if (isEven(array[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static double avgOfEven(int[] array) {
        double sum = sumOfEven(array);
        int counter = numberOfEven(array);
        if (!(counter == 0)) {
            return 0;
        }
        return sum / counter;
    }

    public static int sumOf(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int sumOfOdd(int[] array) {
        return sumOf(array) - sumOfEven(array);
    }


    public static int sumOfEven(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void sumOfPositive(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sum += array[i];
            }
        }
        System.out.println(sum);
        //Suma elementow dodatnich

    }

    public static void greaterThan0(int number) {
        if (number > 0) {
            System.out.println("OK");
        } else {
            System.out.println("Wrong Data");
        }
    }

}
