package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
//import org.junit.Assert;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

// po tym imporcie nie trzeba dopisywac Assert na poczatku metody testowej
import static org.junit.Assert.*;

public class JacksonTest {

    @Test
    public void test1() throws IOException {
        String jsonToDeserialize = "{\"firstName\":\"Bartosz\"," +
                "\"lastName\":\"Nowak\"," +
                "\"addresses\":{\"Home\":{\"street\":\"Al. Niepodległości\",\"city\":\"Poznań\"}}}";

        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(jsonToDeserialize, User.class);

        assertEquals("Bartosz", user.getFirstName());
    }

    @Test
    public void test2() throws IOException {
        String jsonToDeserialize = "{\"originalTitle\":\"Saving Private Ryan\",\"plTitle\":\"Szeregowiec Ryan\",\"director\":{\"firstName\":\"Steven\",\"lastName\":\"Spielberg\"}}";

        ObjectMapper mapper = new ObjectMapper();

        Movie movie = mapper.readValue(jsonToDeserialize, Movie.class);

        assertEquals("Szeregowiec Ryan", movie.getPlTitle());
        assertNull(movie.getBoxOffice());
    }

    @Test
    public void test3() throws IOException {
        String jsonToDeserialize = "{\"originalTitle\":\"Empire Strikes Back\",\"plTitle\":\"Imperium kontratakuje\",\"director\":{\"firstName\":\"Irvin\",\"lastName\":\"Kershner\"}, \"boxOffice\":538375067}";

        ObjectMapper mapper = new ObjectMapper();

        Movie movie = mapper.readValue(jsonToDeserialize, Movie.class);

        assertEquals("Empire Strikes Back", movie.getOriginalTitle());

    }
}
