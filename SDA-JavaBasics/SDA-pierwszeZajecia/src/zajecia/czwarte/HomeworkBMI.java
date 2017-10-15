package zajecia.czwarte;

import java.util.Scanner;

/**
 * Created by RENT on 2017-02-06.
 */
public class HomeworkBMI {

    public static void main(String[] args) {
        BMIresultAndAnalysis();

    }

    public static void BMIresultAndAnalysis() {
        double bmi = BMIcalculator();
        System.out.println("Your Body Mass Index is: " + bmi);
        if (bmi < 18.5) {
            System.out.println("It is in Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 23) {
            System.out.println("It is in Category: Normal Range");
        } else if (bmi >= 23 && bmi < 25) {
            System.out.println("It is in Category: Overweight—At Risk");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("It is in Category: Overweight—Moderately Obese");
        } else {
            System.out.println("It is in Category: Overweight—Severely Obese");
        }
        System.out.println("These ranges are offered as guides. Please keep in mind that you know your body best.");
    }

    public static double BMIcalculator() {
        double weight = getNumberFromUser("Please insert your weight (kilogram): ");
        double height = getNumberFromUser("Please insert your height (meter): ");
        double bmi = weight / (height * height);
        return bmi;
    }

    public static double getNumberFromUser(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        double number = sc.nextDouble();
        return number;
    }
}
