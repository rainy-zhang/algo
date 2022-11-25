package sort;

import java.util.Arrays;

/**
 * <p>
 * 冒泡排序
 * </p>
 *
 * @author zhangyu
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array) {
        boolean swap = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        System.out.println("bubble sort: " + Arrays.toString(array));
    }

}
 