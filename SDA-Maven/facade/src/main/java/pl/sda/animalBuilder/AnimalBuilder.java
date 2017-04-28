package pl.sda.animalBuilder;

public class AnimalBuilder {

    private Animal animal;

    public AnimalBuilder() {
        animal = new Animal();
    }

    public AnimalBuilder withKingdom (String kingdom) {
        animal.setKingdom(kingdom);
        return this;
    }

    public AnimalBuilder withPhylum (String phylum) {
        animal.setPhylum(phylum);
        return this;
    }

    public AnimalBuilder withAnimalClass (String animalClass) {
        animal.setAnimalClass(animalClass);
        return this;
    }

    public AnimalBuilder withOrder (String order) {
        animal.setOrder(order);
        return this;
    }

    public AnimalBuilder withFamily(String family) {
        animal.setFamily(family);
        return this;
    }

    public AnimalBuilder withGenus (String genus) {
        animal.setGenus(genus);
        return this;
    }

    public AnimalBuilder withSpecies (String species) {
        animal.setSpecies(species);
        return this;
    }

    public Animal build() {
        return animal;
    }

}
