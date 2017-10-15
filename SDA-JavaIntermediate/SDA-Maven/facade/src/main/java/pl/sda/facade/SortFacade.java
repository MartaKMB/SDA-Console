package pl.sda.facade;

import pl.sda.observer.Observer;
import pl.sda.sort.Sort;
import pl.sda.sort.impl.CountSort;
import pl.sda.sort.impl.InsertSort;

public class SortFacade {

//    modyfikacja fasady, aby reagowala na bledny argument

//    dodajemy obiekt obserwatora:

    private Observer observer = null;

    public SortFacade() {
    }

    //    przekazywanie w komstruktorze do fasady (konstruktor przyjmuje argument)
//    przekazujemy wart do pola obserwatora

    public SortFacade(Observer observer) {
        this.observer = observer;
    }


//      mamy dostep do metod z pl.sda.sort
//    stowrzona aby obce kody zamknac w obcej klasie

    public int[] sortThroughFacade(int[] arrayToSort) {
        Sort sort = new InsertSort();
        return sort.sort(arrayToSort);
    }

//    modyfikacja do cwiczenia z Observer
//    zmiana zachowania - modyfikacja tablicy wejsciowej
//    zmiana argumentu wejsciowego, dlatego uzywamy observer

    public int[] sortUsingCountSort(int[] arrayToSort) {

//        iteracja po tablicy, jak wart ujemna i obserwator rozny od nullto = 0

        Sort sort = new CountSort();

//        standardowy for a nie for each, zeby sie odwolywac do konkretnego elementu tablicy

        for (int i = 0; i < arrayToSort.length; i++) {

//       obserwator jest nullem jak uzyjemy konstruktora bezargumentowego

            if (arrayToSort[i] < 0 && observer != null) {

//                dodajemy tymczasowa zmienna

                int temp = arrayToSort[i];

                // jak rozne od null powiadomienie obserwatora

                arrayToSort[i] = 0;

//                zmiana na wartosc bezwzgledna
//                arrayToSort[i] = Math.abs(arrayToSort[i]) - wtedy tez zmiana w Observer w wiadomosci

//                wywolanie obserwatora
//                powiadomienie obserwatora przy zmienianiu wartosci wejsciowej
//                zmiana np. z -1 na 0

                observer.react(temp);
            }
        }
        return sort.sort(arrayToSort);
    }

}
