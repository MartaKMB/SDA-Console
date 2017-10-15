package pl.sda.singletonFactory;

import pl.sda.sort.Sort;
// mozemy zrobic rozszerzenie: ale w tym przyp nie ma to sensu
//import pl.sda.sort.factory.SortFactory;
import pl.sda.sort.factory.SortTypeEnum;
import pl.sda.sort.impl.BubbleSort;
import pl.sda.sort.impl.CountSort;
import pl.sda.sort.impl.InsertSort;

public class SingletonSortFactory /*extends SortFactory*/ {

    private static SingletonSortFactory instance = new SingletonSortFactory();

//    musimy taki konstruktor stworzyc, aby przeslonic domyslny

    private SingletonSortFactory() {}

    public static SingletonSortFactory getInstance() {
        return instance;
    }

//    skopiowane z Sort, SortFactory
//    nie robimy tego jak mamy extends

    public static Sort produce(SortTypeEnum type) {

        if (SortTypeEnum.BUBBLE.equals(type)) {
            return new BubbleSort();
        }
        if (SortTypeEnum.COUNT.equals(type)) {
            return new CountSort();
        }
        if (SortTypeEnum.INSERT.equals(type)) {
            return new InsertSort();
        }
        return null;
    }

}
