package pl.sdacademy.game.utils;

import pl.sdacademy.game.model.Gamer;

import java.util.Random;

public class GamerRunnable implements Runnable{

    private Gamer gamer;

    public GamerRunnable(Gamer gamer) {
        super();
        this.gamer = gamer;
    }

    @Override
    public void run() {

        for (int i = 0; i < 2; i++) {
            message("| throw a dice...");
            Random random = new Random();
            int number = random.nextInt(6) + 1;

            int sumNumbers = number + gamer.getCurrent();

            gamer.setCurrent(number);

            message("| threw: " + number);
            message("| sum of threw numbers = " + sumNumbers);

            if(sumNumbers == 7) {
                message("| I win!");
                addPoint();
            }
        }

    }

//    dodanie punktu do listy z wynikami

    private void addPoint() {
        gamer.getMainScore().addPoint(gamer);
    }

    private void message(String message) {
        System.out.println(gamer.getName() + " " + message);
    }
}
