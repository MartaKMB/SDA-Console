package algorytmy.structures.queue;

public interface Queue {

//    public w interface jest domyslne

    void push(int value);

//    informacja o wyjatku:

    int pop() throws QueueException;

    Queue clone();
}
