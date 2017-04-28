package pl.sda.mvc.model;

import java.util.List;

public class ModelFacade {

//    przelotka tylko na metody
//    nie dodajemy tu listy
//    przykrywa metody klasy, ktora chcemy ukryc w reszcie kodu
//    jak jest static nie trzeba tworzyc obiektu, tylko wywolujemy bezposrednio

    public static List<Long> getValuesThroughFacade() {
        return Model.getValues();
    }

    public static void addValueThroughFacade (long newValue) {
        Model.addValue(newValue);
    }
}
