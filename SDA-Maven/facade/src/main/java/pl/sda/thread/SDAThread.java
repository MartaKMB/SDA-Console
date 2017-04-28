package pl.sda.thread;

// watki
// to co odpala watki musi implementowac Runnable

public class SDAThread implements Runnable {

    private int number;

    public SDAThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {

//        aby bylo widac, ze watek dziala caly czas - nieskonczona petla
//        Thread.sleep - wstrzymanie watku na 0.5 sekundy

        while (true) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread number: " + number);
        }
    }
}
