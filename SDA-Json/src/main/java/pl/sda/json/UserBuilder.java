package pl.sda.json;

import java.util.List;
import java.util.Map;

public class UserBuilder {

//    jako pole prywatne budowany obiekt

    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    //    metody zwracajace same siebie

    public UserBuilder withFirstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder withAddress(Map<String, Address> addresses) {
        user.setAddresses(addresses);
        return this;
    }

//    dodatkowa metoda z adresem pobierajaca mape i wrzuca uzywajac klucza

    public UserBuilder withAddress(String addressName, Address address) {

//        z obiektu User pobieram mape i do tej mapy wrzucam adres

        user.getAddresses().put(addressName, address);
        return this;
    }

    public UserBuilder withChildrenNames(List<String> names) {
        user.setChildrenNames(names);
        return this;
    }

//    metoda build zwracajaca User'a

    public User build() {
        return user;
    }

}
