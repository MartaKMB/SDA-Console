package algorytmy.structures;

public class MyList implements MyListInterface{

    private final int INITIAL_SIZE = 10;
    private int[] array;

    // size - faktyczna liczba elementow

    private int size;

    public MyList() {
        this.array = new int[INITIAL_SIZE];
        this.size = 0;
    }

//    nadpisujemy istniejacy element:

    public void put(int index, int value) {
        if(checkIndex(index)) {
            this.array[index] = value;
        }
    }

//    dodajemy element po istniejacym indeksem, zwiekszamy size
//    nie na koncu

    public void add(int index, int value) {
        if(checkIndex(index)) {
            if (this.size >= this.array.length) {
                doubleCapacity();
            }

//            przejscie od konca listy, petla "od tylu"

            for (int i = this.size; i > index ; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.size++;
            this.array[index] = value;
        }
    }

    public void addAll(MyListInterface myList) {
        for (int i = 0; i < myList.getSize(); i++) {
            this.add(myList.get(i));
        }
    }

    public void addAll(int index, MyListInterface myList) {
        for (int i = 0; i < myList.getSize(); i++) {
            add(index + i, myList.get(i));
        }
    }

//    metoda spr czy indeks jest poprawny

    public int get(int index) {
        if(checkIndex(index)) {
            return array[index];
        } else {
            System.out.println("Wrong index");
            return 0;
        }

    }

//  ctrl+alt+m z zaznaczonego fragmentu tworzymy nowa metode

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

//    dodawanie elementu
//    add niczego nie zwraca, void

    public void add(int value) {

//        stawianie wartosci na koniec tablicy
//        if jezeli size juz jest dlugosci tablicy nie mozemy dodac kolejnego elementu

        if(size >= array.length) {

//            System.out.println("[My List] is full");
//            zamiana na doubleCapacity

            doubleCapacity();
        }

//        usuwamy elsa, bo jak ktos chce dodac, zawsze ma sie dodac

            array[size] = value;
            size++;
    }

    public void delete(int index) {
        if(checkIndex(index)) {
            for (int i = index; i < size - 1; i++) {

//                swap(i, i + 1 ); - lepsze rozwiazanie ponizej

                array[i] = array[i + 1];
            }
            size--;
        }
    }

    private void swap(int i1, int i2) {
        int tmp = this.array[i1];
        this.array[i1] = this.array[i2];
        this.array[i2] = tmp;
    }

    public MyListInterface clone() {
        MyList tmpList = new MyList();
        tmpList.array = rewrite(new int[this.array.length]);

//        gdybysmy zrobili jak ponizej robimy referencje a nie klona
//        tmpList.array = this.array

        tmpList.size = this.size;
        return tmpList;
    }

    private void doubleCapacity() {
        doubleCapacity(2);
    }

//   nazwa nie koniecznie poprawna, bo ustalajac 3 nie bedzie "double":

    private void doubleCapacity(int increasingValue) {
        int[] tmpArray = new int[size * increasingValue];
        this.array = rewrite(tmpArray);
    }

    private int[] rewrite(int[] tmpArray) {
        for (int i = 0; i < array.length; i++) {
             tmpArray[i] = this.array[i];
        }
        return tmpArray;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(array[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
