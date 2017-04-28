package pl.sda.singleton;

public class Main {
    public static void main(String[] args) {

//        nie za pomoca konstruktora, bo jest prywatny
//        getInstance musi byc statyczna
//        pobieramy instancje, odwolujemy sie do metody

        Singleton singleton = Singleton.getInstance();

//        getCounter nie musi byc statyczny, bo ale getInstance musi byc statyczna
//        sposob na pobranie obiektu - inny nix konstruktor

        System.out.println(singleton.getCounter() + " " + singleton.getName());

//        pobieramy instancje po raz drugi

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.getCounter()+ " " + singleton.getName());
    }
}
