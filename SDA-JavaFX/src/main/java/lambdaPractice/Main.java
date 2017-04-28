package lambdaPractice;

import pl.sdacademy.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    //    lambda jako argument funkcji

    public static String testLambda(MyLambda lambda, User newUser) {
        return lambda.getLogin(newUser);
    }

    public static void main(String[] args) {

        //        20.03 - lambda

        MyLambda lambda;

//        interfejs jest bezargumentowy
//        przypisanie lambdy do obiektu z klasy MyLambda
//        implementacja
//        w nawiasie argument metody, mogloby byc (User u)
//        -> - "robi sie, wykonuje"


        lambda = (User user) -> {
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("yyyy");
            return "Today is: " + format.format(date) + "My login is: " + user.getLogin();
        };

        User newUser = new User("kowalski", "password");

        System.out.println(lambda.getLogin(newUser));

//        argument lambda i uzytkownik

        System.out.println(testLambda(lambda, newUser));

//        lambda w sout

        System.out.println(testLambda((User user) -> {
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("yyyy");
            return "Today is: " + format.format(date) + "My login is: " + user.getLogin();
        }, newUser));

//        bez lambdy
//        lambda jest szybka do malych rzeczy

        /*

//        bez lambdy w MyLambda bylo getValue bezargumentowo, tylko return "test"

        MyLambda lambda1 = new MyLambdaImpl();
        System.out.println(lambda1.getValue());
        */

//        :: - dzieki temu mozemy uzyc implementacji metody statycznej w klasie
//        lambda, jako implementacja interfejsu/metody
//        maja sie zgadzac typu, czyli np. getLogin a getString
//        przypisujemy tylko akcje

        System.out.println(testLambda(MyClassTest::getString, newUser));

//        zapis rozszerzony, z uzyciem osobnej klasy
//        dzieki lambdzie wykorzystujemy uniwersalne metody

//        lambda = (user) -> user.getLogin() + " MyClassTest";

//        wykorzystanie interfejsu MyLambdaConstr
//        przez ::new odwolujemy sie do konstruktora w klasie User

        MyLamdaConstructor constr = User::new;

//        mozna tez stworzyc User'a tak:
        User user2 = constr.crateUser("login2", "2123");

        System.out.println(constr.crateUser("login", "123"));

        System.out.println(constr);
    }

}
