package pl.sda.sort.factory;

import pl.sda.sort.Sort;
import pl.sda.sort.impl.BubbleSort;
import pl.sda.sort.impl.CountSort;
import pl.sda.sort.impl.InsertSort;


public class SortFactory {

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
