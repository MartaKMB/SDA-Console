package pl.sdacademy.game.main;

import pl.sdacademy.game.model.Gamer;
import pl.sdacademy.game.model.MainScore;
import pl.sdacademy.game.utils.GamerRunnable;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        int threadNumber = 2;

        //        tworzymy pule watkow, pula dostepnych watkow

        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);

//        po utworzeniu klasu MainScore

        MainScore mainScore = new MainScore();
        Gamer gamer1 = new Gamer("Karol", mainScore);
        Gamer gamer2 = new Gamer("Ewa", mainScore);

//        na Executor mozna wywolac execute
//        runnable to interfejs z jedna metoda run - odniesienie do lambdy, mozna w tej postaci zapisac

        /*
        Gamer gamer1 = new Gamer("Karol");
        Gamer gamer2 = new Gamer("Ewa");
        */

//        tworzenie nowego obiektu bezposrednio po stworzeniu metody run

        Runnable thread1 = () -> {
            new GamerRunnable(gamer1).run();
        };

//        inny zapis:

        Runnable thread2 = new GamerRunnable(gamer2);

       /* Runnable thread1 = (Gamer gamer1) -> {

//            watek bedzie rzucal kostka
//            przeniesione do klasy GamerRunnable

            message(gamer1.getName() + "1: throw a dice...");
            Random random = new Random();
            int number = random.nextInt(6) + 1;
            message("1: you threw: " + number);
        };
        */

//        po stworzeniu klasy GamerRunnable


        executor.execute(() -> System.out.println("hello!"));

        executor.execute(thread1);
        executor.execute(thread2);

//        wazne jest shutdown - zakonczenie, jak nie zrobimy zwiekszamy ich ilosc az do nieskonczonosci
//        uniemozliwiamy tworzenie kolejnych watkow i zamykamy te, ktore wywolujemy w executor

        executor.shutdown();

//        nie mamy synchronizacji, dlatego summary nie zawsze tak, jak powinna

    }
}
