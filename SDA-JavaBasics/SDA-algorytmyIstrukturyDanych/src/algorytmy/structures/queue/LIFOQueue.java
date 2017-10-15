package algorytmy.structures.queue;

public class LIFOQueue extends AbstractQueue {

//    zmienne wykorzystywane z klasy abstrakcyjnej

    public LIFOQueue() {
    }

    public LIFOQueue(int value) {

//        wywolujemy konstruktor z nadklasy, siegamy do wygenerowanej metody

        super(value);
    }

    @Override
    protected AbstractQueue getInstance() {
        return new LIFOQueue();
    }

    @Override
    protected AbstractQueue getInstance(int value) {
        return new LIFOQueue(value);
    }

//    dodajemy element "za glowa"

    @Override
    public void push(int value) {
        AbstractQueue nextValue = this.next;
        LIFOQueue newValue = new LIFOQueue(value);
        this.next = newValue;
        newValue.next = nextValue;

    }

//    pop, toString, clone z klasy abstrakcyjnej
}
