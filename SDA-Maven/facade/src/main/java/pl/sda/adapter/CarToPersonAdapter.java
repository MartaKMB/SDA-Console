package pl.sda.adapter;

//    oznaczenie ze implementuje interfejs Person - ten do ktorego transformujemy

public class CarToPersonAdapter implements Person {

//    aby moc uzywac samochodu jako osoby

    private Car car;

//    przekazac odniesienie do pola Car
//    mozna tez w seterze zamiast konstruktora

    public CarToPersonAdapter(Car car) {
        this.car = car;
    }

    //    adapter musi miec pole obiekt adaptowany

    @Override
    public void move() {
        car.drive();
    }

    @Override
    public void say() {
        car.horn();
    }

}
