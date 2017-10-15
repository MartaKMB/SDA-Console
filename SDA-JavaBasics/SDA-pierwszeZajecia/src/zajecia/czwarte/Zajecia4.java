package zajecia.czwarte;

import java.util.Scanner;

/**
 * Created by RENT on 2017-02-04.
 */
public class Zajecia4 {
    public static void main(String[] args) {
        /*
        printLessThan(5);
        System.out.println();

        printEvenLessThan(5);
        System.out.println();

        int sum = sumOfLessThan(5);
        System.out.println(sum);
        System.out.println();

        int product = productOfLessThan(5);
        System.out.println(product);
        */

        /*
        double celToFahr = celsiusToFahrenheit(2);
        System.out.println(celToFahr);

        double fahrToCel = fahrenheitToCelsius(67);
        System.out.println(fahrToCel);
        System.out.println();
        */

        int[] arrayForStatistic = {1, 2, 3, 4, 5, 6, 7, 88, 9};
        int[] arrayStatistic2 = {3, 4, 6, 61, 53};

        statisticFromArray(arrayForStatistic);
        System.out.println();
        statisticFromArray(arrayStatistic2);

    }


    public static void statisticFromArray(int[] array) {
        System.out.println("Sum of array elements is: " + sumOfArrayElements(array));
        System.out.println("Number of even elements in array: " + numberOfEvenInArray(array));
        System.out.println("Number of odd elements in array: " + numberOfOddInArray(array));
        System.out.println("Number of all elements in array: " + numberOfAllInArray(array));
        System.out.println("Average of elements in array is: " + avgOfArrayElements(array));
        System.out.println("Product of all elements in array: " + productOfArrayElements(array));
        System.out.println("End of statistic.");
    }

    public static int productOfArrayElements(int[] array) {
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        return product;
    }

    public static double avgOfArrayElements(int[] array) {
        double avgAll = (double) sumOfArrayElements(array) / numberOfAllInArray(array);
        return avgAll;
        // numAll = array.length
    }

    public static int numberOfAllInArray(int[] array) {
        int numAll = numberOfOddInArray(array) + numberOfEvenInArray(array);
        return numAll;
    }

    public static int numberOfOddInArray(int[] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (!isEven(array[i])) {
                counter++;
            }
        }
        return counter;
        // array.length - numberOfEvenInArray(array);
    }

    public static int numberOfEvenInArray(int[] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumOfArrayElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double fahrenheitToCelsius(double value) {
        double fahrToCel = ((double) 5 / 9) * (value - 32);
        return fahrToCel;
    }

    public static double celsiusToFahrenheit(double value) {
        double celTofahr = 32 + (((double) 9 / 5) * value);
        return celTofahr;
    }

    public static int productOfLessThan(int number) {
        int product = 1;
        for (int i = 1; i <= number; i++) {
            product *= i;
        }
        return product;
    }

    public static int sumOfLessThan(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public static void printEvenLessThan(int number) {
        for (int i = 0; i <= number; i += 2) {
//            if (i % 2 == 0) {
//            }
            System.out.println(i);
        }
    }

    public static void printLessThan(int number) {
        for (int i = 0; i <= number; i++) {
            System.out.println(i);
        }
    }


}
