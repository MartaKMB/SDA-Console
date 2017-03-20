package lambdaPractice;

import lambdaPractice.MyLambda;
import pl.sdacademy.model.User;

public class MyLambdaImpl implements MyLambda {
    @Override
    public String getLogin(User user) {
        return user.getLogin();
    }
}
