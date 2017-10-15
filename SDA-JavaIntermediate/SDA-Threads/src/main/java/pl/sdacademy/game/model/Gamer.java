package pl.sdacademy.game.model;

public class Gamer {

    private String name;
    private int score;
    private int current;

//    lista z wynikami

    private MainScore mainScore;

    private boolean isDone;

    public Gamer() {
    }

    public Gamer(String name) {
        this.name = name;
        this.score = 0;
        this.current = 0;
    }

    public Gamer(String name, MainScore mainScore) {
        this(name);
        this.mainScore = mainScore;
        mainScore.add(this);
        this.isDone = false;
    }

    public MainScore getMainScore() {
        return mainScore;
    }

    public void setMainScore(MainScore mainScore) {
        this.mainScore = mainScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", result='" + score + '\'' +
                '}';
    }
}
