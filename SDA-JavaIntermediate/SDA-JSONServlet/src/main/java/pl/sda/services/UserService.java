package pl.sda.services;

import org.codehaus.jackson.map.ObjectMapper;
import pl.sda.entities.User;
import pl.sda.servlets.responses.CreateUserResponse;
import pl.sda.servlets.responses.DeleteUserResponse;
import pl.sda.servlets.responses.UpdateUserResponse;
import pl.sda.storage.Storage;

import java.io.IOException;
import java.util.UUID;

public class UserService {

//    metoda dodajacego nowego user'a na wejsciu string z nowym userem

    public CreateUserResponse addUser(String userJson) {

//        mappper zeby przeparsowac user do json'a

        ObjectMapper mapper = new ObjectMapper();
        CreateUserResponse response = new CreateUserResponse();

//        deserializacja w try/catch

        try {
            User user = mapper.readValue(userJson, User.class);

//            dodajemy losowe id

            UUID id = UUID.randomUUID();
            user.setId(id);

//            wpisanie uzytkownika do "pseudo" bazy danych

            Storage.addUser(user);

            response.setStatus("OK");
            response.setId(id.toString());

        } catch (IOException e) {
            response.setError(e.getMessage());
        }

        return response;
    }

    public User getUserByUUID(String id) {

        User result = null;
        if (id != null && !id.isEmpty()) {
            UUID uuid = UUID.fromString(id);
            for (User user : Storage.getUsers()) {
                if (uuid.equals(user.getId())) {
                    result = user;
                    break;
                }
            }
        }

        return result;
    }

    public DeleteUserResponse removeUserById(String id) {

        DeleteUserResponse result = new DeleteUserResponse();
        result.setMessage("USER WITH ID: " + id + " NOT FOUND");

        if (id != null && !id.isEmpty()) {
            User tmpUser = null;
            UUID uuid = UUID.fromString(id);
            for (User user : Storage.getUsers()) {
                if (uuid.equals(user.getId())) {
                    tmpUser = user;
                    break;
                }
            }
            Storage.getUsers().remove(tmpUser);
            result.setStatus("OK");
            result.setMessage("USER WITH ID: " + id + " WAS REMOVED");
        }
        return result;
    }

    /*
//    samodzielnie budowana metoda do remove - usuwanie uzytkownika po id
//      bez DeleteUserResponse

    public String removeUserByUUID(String id) {

        String result = "No user found";

        if (id != null && !id.isEmpty()) {
            User tmpUser = null;
            UUID uuid = UUID.fromString(id);
            for (User user : Storage.getUsers()) {
                if (uuid.equals(user.getId())) {
                    tmpUser = user;
                    break;
                }
            }
            Storage.getUsers().remove(tmpUser);
            result = "User removed";
        }
        return result;
    }
    */

    public UpdateUserResponse updateUser(User user) {
        UpdateUserResponse response = new UpdateUserResponse();

        Storage.updateUser(user);

        response.setStatus("OK");
        response.setMessage("USER UPDATED");

        return response;
    }

}
