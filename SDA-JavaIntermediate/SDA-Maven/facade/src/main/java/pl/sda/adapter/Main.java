package pl.sda.adapter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        tworzymy dwa nowe obiekty - dane wejsciowe

        Car car = new CarImpl();
        Person person = new PersonImpl();

//        towrzymy adapter
//        chcemy symulowac, ze samochod jest osoba

        CarToPersonAdapter carToPersonAdapter = new CarToPersonAdapter(car);

        List<Person> personsList = new ArrayList<>();

//        dodajemy do listy obiekt osoby i adaptera

        personsList.add(person);
        personsList.add(carToPersonAdapter);

//        jedna petla dla car i person - dzieki temu, ze mamy adapter

        for (Person personFromList : personsList) {
            personFromList.move();
            personFromList.say();
        }

        System.out.println();

//        uzycie adaptera PersonToCarAdapter

        PersonToCarAdapter personToCarAdapter = new PersonToCarAdapter(person);

        List<Car> carsList = new ArrayList<>();

        carsList.add(car);
        carsList.add(personToCarAdapter);

        for (Car carFromList : carsList) {
            carFromList.drive();
            carFromList.horn();
        }

    }

    /*
//    bez adaptera
    public static void main(String[] args) {
        Car car1 = new CarImpl();
        Car car2 = new CarImpl();

        Person person1 = new PersonImpl();
        Person person2 = new PersonImpl();

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        for (Person personFromList : personList) {
            personFromList.move();
            personFromList.say();
        }

        for (Car carFromList : carList) {
            carFromList.drive();
            carFromList.horn();
        }
    }
    */
}
