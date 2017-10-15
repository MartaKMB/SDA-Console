package algorytmy.sort;

public class SortUtils {
    public static  void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
