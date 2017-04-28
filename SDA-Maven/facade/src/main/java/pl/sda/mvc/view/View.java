package pl.sda.mvc.view;

import pl.sda.mvc.controller.Controller;

import java.util.Scanner;

public class View {

//    main, bo potrzebujemy punkt wejscia
//    w rzeczywistej aplikacji np. kod interfejsu graficznego

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        w nieskonczonej petli

        while (true) {
            Integer choice = scanner.nextInt();
            Controller controller = new Controller();

//            liczby ujemne jako funkcja sterujace
//            widok decyduje ktora metode wywola
//            jezeli jest dodatnia fib, ujemna srednia

            if (choice != null && choice > 0) {
                long result = controller.getFibValue(choice);
                System.out.println("FIB =" + result);
            } else {
                System.out.println("AVG = " + controller.average());
            }
        }

    }
}
