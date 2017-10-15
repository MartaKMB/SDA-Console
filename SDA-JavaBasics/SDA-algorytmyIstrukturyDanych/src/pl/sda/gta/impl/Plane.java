package pl.sda.gta.impl;

import pl.sda.gta.Vehicle;

// pierwsze zajecia z Michalem

public class Plane implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Samolot leci");
    }

    @Override
    public void explode() {
        System.out.println("Samolot wybucha");

    }
}
