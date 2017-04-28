package pl.sda.observer;

public class Observer {

//    obserwator reaguje
//    CountSort wywala sie przy ujemnych wiec - modyfikacja SortFacade
//    try/catch jest przy bledach, a obserwator nie tylko
//    np. taki login juz istnieje, powiadomienie

    public void react(int value) {
        System.out.println("Value: " + value + " is changed to 0");

//        gdyby bylo Math.abs w SortFacade, to tutaj na koniec dodajemy + Math.abs(value)
    }

}
