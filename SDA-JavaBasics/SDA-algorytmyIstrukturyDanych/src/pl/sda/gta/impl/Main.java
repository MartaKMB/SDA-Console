package pl.sda.gta.impl;

import pl.sda.gta.Vehicle;

import java.util.ArrayList;
import java.util.List;

// pierwsze zajecia z Michalem

public class Main {

    public static void main(String[] args) {
        List<Vehicle> listaPojazdow = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                listaPojazdow.add(new Car());
            }
            if (i % 5 == 0) {
                listaPojazdow.add(new Plane());
            }
            if (i % 7 == 0) {
                listaPojazdow.add(new Bike());
            }
            if (i % 11 == 0) {
                listaPojazdow.add(new Tank());
            }
        }

        for (Vehicle pojazd : listaPojazdow) {
            pojazd.drive();
        }

//        jedna lista, ale 4 rozne opcje implementacji
    }
}
