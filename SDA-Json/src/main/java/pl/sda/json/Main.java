package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        User user1 = new User();
        user1.setFirstName("Jan");
        user1.setLastName("Kowalski");

        Address address1 =  new Address();
        address1.setStreet("Baraniaka");
        address1.setCode("11-111");
        address1.setCity("Poznan");

        Address address2 = new Address();
        address2.setStreet("Krolowej Jadwigi");
        address2.setCode("22-222");
        address2.setCity("Krakow");

        Map<String, Address> addresses = new HashMap<>();
        addresses.put("Home", address1);
        addresses.put("Work", address2);

        user1.setAddresses(addresses);

        List<String> childrenNames = Arrays.asList("Marek", "Zosia");

        user1.setChildrenNames(childrenNames);

//        mamy obiekt, ktory mozemy zserializowac,
//        tworzymy maper'a - ktory przeksztalca obiekt na stringa zawierajacego json'a

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user1);

        System.out.println(json);

    }
}
