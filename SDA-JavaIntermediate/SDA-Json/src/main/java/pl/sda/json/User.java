package pl.sda.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  informacja dla programisty, ze klasa jest serializowana
//  (nie doslownie, ale tzn. przerabiana na stringa)
//   zmiana pliku java na json'a

// adnotacja, aby maper nie wyswietlal null'ow, ma zostac pominieta
// jest rowniez opcja NON_EMPTY - uwzglednia null'a i pusta np. tablice

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {
    private String firstName;
    private String lastName;

//    adresy zapisane w mapie (czyli przypisanie kluczowi wartosci, klucze unikalne
//    generujemy mape i liste i do nich gettery i settery

    private Map<String, Address> addresses = new HashMap<>();

    private List<String> childrenNames = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(List<String> childrenNames) {
        this.childrenNames = childrenNames;
    }
}
