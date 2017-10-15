package pl.sda.decorator;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.sort.impl.BubbleSort;

public class DecoratorTest {

//    nie robimy konstruktora z zalozenia

//    klasy testowe porzedzane adnotacja @Test
//    po @Test - automatycznie import

    @Test
    public void testDecorator() {

        // given
//        paramnetry wejsciowe

        int[] arrayToSort = {55, 33, 77, 1, -9, 57, 321, -111};
        SortDecoratorWithReverse decoratedSort = new SortDecoratorWithReverse(new BubbleSort());

        // when
//        warunek ("majac tablice oraz obiekt dekoratora, to...

        int[] result = decoratedSort.sort(arrayToSort);

//        sprawdzenie, czy mamy dobre wartosci
//        przewidujemy, jaka liczba bedzie na 0 pozycji

        // then
//        to...

        Assert.assertEquals(321, result[0]);
        Assert.assertEquals(-111, result[result.length-1]);
    }
}
