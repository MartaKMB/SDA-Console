package pl.sda.gta.impl;

import pl.sda.gta.Vehicle;

// pierwsze zajecia z Michalem

public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Motocykl jedzie");
    }

    @Override
    public void explode() {
        System.out.println("Motocykl wybucha");
    }
}
