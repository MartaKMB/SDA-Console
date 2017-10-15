package pl.sda.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

//    w nim trzymamy wartosci

    public static List<Long> values = new ArrayList<>();

    public static List<Long> getValues() {
        return values;
    }

//    parametr maly int - autoboxing
//    z malego na duzy konwersja bezpieczna
//    odwortinie moze sie pojawic NullPointerException

    public static void addValue (long newValue) {
        values.add(newValue);
    }
}
