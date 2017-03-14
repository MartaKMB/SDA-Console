package pl.sdacademy.service;

import pl.sdacademy.model.User;

public class UserService {

    public UserService() {
    }

    public boolean authenticate(User user) {

//        weryfikacja hasla i loginu z argumentem User, ktore zostalo wprowadzone
//        pobieramy password z User, gdy mamy wiecej niz jednego user'a
//        pobieramy userFromFile, czyli user'a z pliku
//        sprawdzamy czy password user'a z z userFromFile

        DataService dataService = new DataService();

        User userFromFile = dataService.loadData();

        return  user.equals(userFromFile);

    }
}
