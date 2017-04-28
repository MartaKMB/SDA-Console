package pl.sdacademy.model;

public enum StreetPrefix {

//    wartosci polskie, ale zmienne po angielsku

    STREET("ul."), AVENUE("al."), SQUERE("pl.");

//    aby wydrukowac enum

    private final String prefix;

    StreetPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
