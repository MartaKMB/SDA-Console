package pl.sda.animalBuilder;

public class Main {
    public static void main(String[] args) {
        AnimalBuilder animalBuilder = new AnimalBuilder();

        Animal animal = animalBuilder.withKingdom("Animal/Animalia").withPhylum("Chordata").withAnimalClass("Bird/Aves")
                .withOrder("Charadriiformes").withFamily("Alcidae").withGenus("Fratercula")
                .withSpecies("Atlantic puffin/Fratercula arctica/Maskonur zwyczajny").build();

        System.out.println(animal.toString());
    }
}
