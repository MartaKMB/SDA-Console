package pl.sda.animalBuilder;

public class Animal {

    private String kingdom;
    private String phylum;
    private String animalClass;
    private String order;
    private String family;
    private String genus;
    private String species;

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {

        return "Scientific classification of " + species + ": \n"
                + "\n" + "{" +
                "kingdom='" + kingdom + '\'' + "\n" +
                "phylum='" + phylum + '\'' + "\n" +
                "animalClass='" + animalClass + '\'' + "\n" +
                "order='" + order + '\'' + "\n" +
                "family='" + family + '\'' + "\n" +
                "genus='" + genus + '\'' + "\n" +
                "species='" + species + '\'' +
                '}';
    }
}
