package test.algorytmy.structures.queue;

import algorytmy.structures.queue.FIFOQueue;
import algorytmy.structures.queue.Queue;
import algorytmy.structures.queue.QueueException;

public class FIFOQueueTests {
    public static void main(String[] args) throws QueueException {

        Queue queue = new FIFOQueue();

//        chcemy pobrac a jeszcze nic nie mamy, wiec informacja / wyjatek

        queue.pop();
        System.out.println(queue);

        queue.push(3);
        queue.push(42);
        queue.push(-7);
        queue.push(13);
        System.out.println("After push: " + queue);

        System.out.println();

        /*
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println("After pop: " + queue);
        queue.pop();
        System.out.println("Queue is empty: " + queue);

        System.out.println();
        */

        System.out.println("Queue: " + queue);
        Queue clonedQueue = queue.clone();
        System.out.println("Queue: " + queue);
        System.out.println("Cloned Queue: " + clonedQueue);
        System.out.println("Queue: " + queue);

        System.out.println();

        queue.pop();
        System.out.println("Pop: " + queue);


    }
}
