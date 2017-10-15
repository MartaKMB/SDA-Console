package pl.sda.adapter;

public class PersonImpl implements Person {
    @Override
    public void move() {
        System.out.println("I move.");
    }

    @Override
    public void say() {
        System.out.println("I say something.");
    }
}
