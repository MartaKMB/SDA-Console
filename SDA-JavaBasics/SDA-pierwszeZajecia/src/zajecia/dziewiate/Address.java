package zajecia.dziewiate;

/**
 * Created by RENT on 2017-02-11.
 */
public class Address {
    public String street;
    public int houseNumber;
    public String zipCode;
    public String city;
    public String land;

//      konstruktor :
//      (po jego usunieciu domyslny "znika",
//      mozna miec kilka konstruktorow z roznymi argumentami, jest rozpoznawany po liczbie argumentow)
    public Address(String street, int houseNumber, String zipCode, String city, String land) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.land = land;
    }

    public void printAdress() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(zipCode)
                .append(" ")
                .append(city)
                .append(", ")
                .append(street)
                .append(" ")
                .append(houseNumber)
                .append(", ")
                .append(land);
        String toPrint = sb.toString();
        System.out.println(toPrint);
    }
}
