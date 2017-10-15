package zajecia;

public class Zajecia1 {
    public static void main(String[] args) {
//        checkEvenOrOdd();
//        array();
//        displayArray();
//        listEven();
//        sumOfEven();
//        sumOfArray();
    }

    public static void sumOfArray() {
        int[] array = {1,2,3,4,5};
        int sum = 0;
        for (int i = 0 ; i < array.length ; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

    public static void sumOfEven() {
        int[] array = {2,4,1,22,4,63,2,1};
        int sum = 0;
        for (int i = 0 ; i < array.length ; i ++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }

    public static void listEven() {
        int[] array = {2,4,1,22,4,63,2,1};
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] % 2 == 0) {
                System.out.println(array[i]);
            }
        }
    }

    public static void displayArray() {
        int[] array = {1, 3, 2, 5, 7, 4, 2};
        for (int i = 0; i < array.length; i++) {
        }
    }

    public static void array() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        int index = 2;
        if (index >= 0 && index < array.length) {
            if (array[index] % 2 == 0) {
                System.out.println("Number is even");
            } else {
                System.out.println("Number is odd");
            }
        } else {
            System.out.println("Wrong index");
        }
    }

    public static void checkEvenOrOdd() {
        int number = 3;
        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }

    public static void greaterThan0() {
        int number = 5;
        if (number > 0) {
            System.out.println("OK");
        } else {
            System.out.println("Wrong Data");
        }
    }

    public static void checkAge() {
        int age = 13;
        String okMessage = "Under 18. Your age is " + age;
        if (age < 18) {
            System.out.println(okMessage);
        } else {
            System.out.println("You'r ok");
        }
    }
}
