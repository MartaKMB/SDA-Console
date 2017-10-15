package pl.sdacademy.game.model;

import java.util.ArrayList;
import java.util.List;

public class MainScore {

    List<Gamer> gamers;

    public MainScore() {
        gamers = new ArrayList<>();
    }

    public void add(Gamer gamer) {
        gamers.add(gamer);
    }

    public void addPoint(Gamer gamer) {
        gamers.stream()
                .filter(g -> g.getName().equals(gamer.getName()))
                .forEach((Gamer g) ->  {
                    g.setScore(g.getScore() +1);
                    g.setDone(true);
                });
        printSummary();
    }

    public void printSummary() {

//        ile jest gamer'ow, ktorzy nie skonczyli

        long count =
                gamers.stream()
                .filter(g -> g.isDone()==false).count();

//        jezeli wszyscy skonczyli wypisz podsumowanie

        if(count == 0) {
            System.out.println("=== Summary");
            gamers.forEach(System.out::println);
        }
    }
}
