package pl.sda.adapter;

public class CarImpl implements Car{
    @Override
    public void drive() {
        System.out.println("Drive.");
    }

    @Override
    public void horn() {
        System.out.println("Make honk.");

    }
}
