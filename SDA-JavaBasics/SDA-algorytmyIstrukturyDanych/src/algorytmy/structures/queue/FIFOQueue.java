package algorytmy.structures.queue;

// jak zrobimy extends AbstractQueue to nie robimy juz implements Queue
// rozszerzenie klasy abstrakcyjnej i jej metod

public class FIFOQueue extends AbstractQueue {

    public FIFOQueue() {
    }

    public FIFOQueue(int value) {
        super(value);
    }

//    metoda z klasy abstrakcyjnej, zwraca cos abstrakcyjnego

    @Override
    protected AbstractQueue getInstance() {
        return new FIFOQueue();
    }

    @Override
    protected AbstractQueue getInstance(int value) {
        return new FIFOQueue(value);
    }

    @Override
    public void push(int value) {
        AbstractQueue last = getLast();
        last.next = new FIFOQueue(value);
    }

    /*
//    aby przejsc na ostatni element, prywatna do push'a
//    przenosimy do abstrakcyjnej, jako protected, bo i tak odnosi sie do AbstractQueue
    private AbstractQueue getLast() {
        AbstractQueue fifoQueue = this;
        while (fifoQueue.next != null) {
            fifoQueue = fifoQueue.next;
        }
        return fifoQueue;
    }
    */

    /*
//    usuwamy, bo sa takie same w FIFO i LIFO, wiec do abstract
    @Override
    public int pop() {
//        jezeli kolejka jest pusta
        if (this.next == null) {
            System.out.println("Queue is empty");
            return 0;
        }
//        przypisanie elementu, ktory sie wykona z kolejnki
        FIFOQueue first = this.next;
//        przestawiamy this'a na kolejna wartosc, obejscie 1szego elementu
        this.next = first.next;
//        odcinamy "sznurek"
        first.next = null;
//        zwracamy wartosc first'a, na chwile obecna nie uzywamy
        return first.value;
    }
    */

    /*
//    clone z klasy abstrakcyjnej
    @Override
    public Queue clone() {
//        nowa pusta kolejka:
        FIFOQueue clonedQueue = new FIFOQueue();
//        dodatkowa kolejka:
        FIFOQueue returnQueue = clonedQueue;
//        ustawiamy next zeby przechodzic po kolejce
        FIFOQueue tmpQue = this.next;
        while (tmpQue != null) {
//            czytamy wartosc z oryginalu, tworzymy nowy element z ta wartoscia
//            - przestawiamy, wiec nie mamy wgladu do ostanich,
//              dlatego returnQueue dodatkowa zmienna
            clonedQueue.next = new FIFOQueue(tmpQue.value);
//            przeskakujemy na kolejny elemen=nt
            tmpQue = tmpQue.next;
//            chcemy dodawac do nastepny element:
            clonedQueue = clonedQueue.next;
        }
        return returnQueue;
    }
    */

    /*
//    usuwamy, bo dziedziczony z klasy abstrakcyjen
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
//        this.next - pomijamy glowe, z glowa this, ale wtedy mozemy pominac ostatni element
        FIFOQueue fifoQueue = this.next;
        stringBuilder.append("[");
        while (fifoQueue != null) {
            stringBuilder.append(fifoQueue.value);
            if (fifoQueue.next != null) {
                stringBuilder.append(", ");
            }
            fifoQueue = fifoQueue.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    */
}
