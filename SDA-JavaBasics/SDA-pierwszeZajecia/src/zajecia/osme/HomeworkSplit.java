package zajecia.osme;

/**
 * Created by Muszka on 2017-02-10.
 */
public class HomeworkSplit {
    public static void main(String[] args) {

        String message = "Ala has cat and dogs";
//        String[] array1 = split1(message);
        String[] array2 = split2(message);
        for (int i = 0; i < array2.length ; i++) {
            System.out.println(array2[i]);
        }

    }

    public static String[] split2(String message) {
        String[] strings = new String[100];
        int i = 0;
        int tmp = 0;
        boolean flag = true;
        while(flag) {
            int indexOfSpace = message.indexOf(' ', tmp);
            String substring;
            if (indexOfSpace == -1) {
                substring = message.substring(tmp);
            } else {
                substring = message.substring(tmp, indexOfSpace);
            }
            strings[i] = substring;
            tmp = indexOfSpace + 1;
            i++;
            if (indexOfSpace == -1) {
                flag = false;
            }
        }
        return rewrite(strings, i);
    }

    public static String[] rewrite(String[] array, int size) {
        String[] tmpArray = new String[size];
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i] = array[i];
        }
        return tmpArray;
    }

    public static String[] split1(String message) {
        return message.split(" ");
    }
}
