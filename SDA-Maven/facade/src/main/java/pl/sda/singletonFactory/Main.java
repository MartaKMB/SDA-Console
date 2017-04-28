package pl.sda.singletonFactory;

import pl.sda.sort.Sort;
import pl.sda.sort.factory.SortTypeEnum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SingletonSortFactory factory = SingletonSortFactory.getInstance();

        Sort sort = factory.produce(SortTypeEnum.BUBBLE);

        int[] sortedArray = sort.sort(new int[]{123, 456, -76, 98, -45, 75, 43, -23});

        System.out.println(Arrays.toString(sortedArray));
    }
}
