package lambdaPractice;

import pl.sdacademy.model.User;

public class MyClassTest {

    public MyClassTest() {
    }

    public static String getString(User user) {
        return user.getLogin() + " MyClassTest";
    }

//    metoda ta moze stac sie implementacja
}
