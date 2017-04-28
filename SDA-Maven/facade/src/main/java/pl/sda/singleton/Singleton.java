package pl.sda.singleton;

/**
 * Created by RENT on 2017-02-25.
 */
public class Singleton {

//    jedno pole z sama soba
//    pole statyczne, czyli rowne null - jak zmieni sie dla jednego obiektu zmieni sie dla wszystkich
//    zawsze istnieje tylko jedna taka wartosc
//    zmienna globalna dla wszystkich obiektow klasy

//    zamienilismy = null;
//    zamiast null new Singleton - dwa wywolania w tym samym momencie
//    zanim utworzy sie obiekt moze drugi watek wywola getInstance i zanim zostanie spr
//    utworzy sie nowy obiekt - Singleton zabezpieczony watkowo

    private static Singleton instance = new Singleton();

//    counter, zebysmy widzieli, ze zawsze bedzie 0

    private static int counter = 0;

//    konstruktor prywatny, nie mozna uzyc z zewnatrz

    private Singleton () {
        counter++;
    }


//    umozliwienie pobrania instancji juz istniejaca

    public static Singleton getInstance() {

        return instance;

        //    sprawdza czy istnieje instancja singletona - jest rozna od nulla
        //    jak jest to zwracamy, jak nie to zwracamy
        /*
//        wyrzucamy bo zawsze bedziemy mieli przypisana wartosc
        Singleton result = instance;
        if(instance != null) {
            result = instance;
        } else {
            return result;
        }
        */
    }

    public int getCounter() {
        return counter;
    }

//    wariant nie uwzgledniajacy tego, ze jak 2 watki odwoluja sie do implementacji
//    zanim wywola sie obiekt

    public String getName() {
        return "Singleton";
    }
}
