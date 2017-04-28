package pl.sda.storage;

import pl.sda.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


// DAO: Data Access Object - klasa pozwalajaca na dostep do danych

public class Storage {

//    magazyn, gdzie trzymamy uzytkownikow
//        wrzucamy user'ow do listy

    private static List<User> users = new ArrayList<>();

    public static void addUser (User user) {
        users.add(user);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static void updateUser(User user) {
        UUID id = user.getId();

//        wyszukujemy uzytkownika, ktory ma takie samo id i zamieniamy wartosci
//        to mogloby byc rowniez w UserService

        for(User userToUpdate : users) {
            if (userToUpdate.getId().equals(id)) {
                userToUpdate.setLogin(user.getLogin());
                userToUpdate.setMail(user.getMail());
                userToUpdate.setName(user.getName());
            }
        }
    }
}
