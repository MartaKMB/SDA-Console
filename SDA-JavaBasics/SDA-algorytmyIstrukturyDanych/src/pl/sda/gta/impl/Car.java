package pl.sda.gta.impl;

import pl.sda.gta.Vehicle;

// pierwsze zajecia z Michalem

public class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Samochod jedzie");
    }

    @Override
    public void explode() {
        System.out.println("Samochod wybucha");

    }
}
