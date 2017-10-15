package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class JsonMapperTest {

    @Test
    public void test1() throws IOException {

//        podajemy wartosc wyjsciowa, z konsoli, z Maina

        String jsonToDeserialize = "{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"addresses\":{\"Work\":{\"street\":\"Krolowej Jadwigi\",\"code\":\"22-222\",\"city\":\"Krakow\"},\"Home\":{\"street\":\"Baraniaka\",\"code\":\"11-111\",\"city\":\"Poznan\"}},\"childrenNames\":[\"Marek\",\"Zosia\"]}\n";

        ObjectMapper mapper = new ObjectMapper();

//        do deserializacji uzywamy metody readValue(co deserializujemy, do czego)

        User user = mapper.readValue(jsonToDeserialize, User.class);

//        metody sprawdzajace, czy obiekt ma ustawione takie wartosci, jakich oczekujemy

        Assert.assertEquals("Jan", user.getFirstName());

        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames() != null);

        Assert.assertTrue(user.getChildrenNames().size() == 2);

        Assert.assertEquals(Arrays.asList("Marek", "Zosia"), user.getChildrenNames());

    }

    @Test
    public void test2() throws IOException {

//        tworzenie obiektu do serializacji przy pomocy buildera
//        withAddress - w nim kolejny Builder

        User user = new UserBuilder().withFirstName("Jan").withLastName("Kowalski")
                .withAddress("Home", new AddressBuilder().withCity("Poznan").withCode("11-111").withStreet("Baraniaka").build())
                .withAddress("Work", new AddressBuilder().withCity("Krakow").withCode("22-222").withStreet("Krolowej Jadwigi").build())
                .withChildrenNames(Arrays.asList("Marek", "Zosia"))
                .build();

        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

//        raczej nie testuje sie stringow, mozna tez zaufac json'owi

        Assert.assertTrue(serializedObject.contains("\"firstName\":\"Jan\""));
        Assert.assertTrue(serializedObject.contains("Kowalski"));
        Assert.assertTrue(serializedObject.contains("Zosia"));

    }

    @Test
    public void test3() throws IOException {

        User user = new UserBuilder().withFirstName("Jan").withLastName("Kowalski")
                .withAddress("Home", new AddressBuilder().withCity("Poznan").withCode("11-111").withStreet("Baraniaka").build())
                .withAddress("Work", new AddressBuilder().withCity("Krakow").withCode("22-222").withStreet("Krolowej Jadwigi").build())
                .withChildrenNames(null)
                .build();

        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

//        przekazujemy nulla w withChildrenNames, z include w klasie User po prostu nie wyswietla
//        bez include w klasie User wyswietla json'a z wartoscia null

        System.out.println(serializedObject);

    }
}
