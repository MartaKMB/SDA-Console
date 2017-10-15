package pl.sda.gta.impl;

import pl.sda.gta.Vehicle;

// pierwsze zajecia z Michalem

public class Tank implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Czolg jedzie");
    }

    @Override
    public void explode() {
        System.out.println("Czolg wybucha");

    }
}
