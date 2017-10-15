package test.algorytmy.structures.queue;

import algorytmy.structures.queue.LIFOQueue;
import algorytmy.structures.queue.Queue;
import algorytmy.structures.queue.QueueException;

public class LIFOQueueTests {
    public static void main(String[] args) {

        Queue queue = new LIFOQueue();

//        jak nie ma w nazwie klasy throws Exception, mozna surround with try/catch
//        lapiemy wyjatek
//        catch okresla jaki wyjatek chcemy lapac

        try {
            queue.pop();
        } catch (QueueException e) {
            e.printStackTrace();
        } finally {
            System.out.println("The End.");
        }


        System.out.println(queue);

        System.out.println();

        queue.push(3);
        queue.push(4);
        queue.push(2);
        queue.push(-1);
        System.out.println("After push: " + queue);

        System.out.println();

        Queue clonedQueue = queue.clone();
        System.out.println("Cloned Queue: " + clonedQueue);


        System.out.println();

//        wyswietlanie elementow dodanych jako ostatnie:

        /*
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println();

        System.out.println("After pop: " + queue);
        */
    }
}
