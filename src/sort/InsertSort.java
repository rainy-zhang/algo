package sort;

import java.util.Arrays;

/**
 * <p>
 * 插入排序
 * </p>
 *
 * @author zhangyu
 */
public class InsertSort implements Sort {

    @Override
    public void sort(int[] array) {
        array = new int[]{5, 4, 3, 2, 1};
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
        System.out.println("insert sort: " + Arrays.toString(array));
    }

}
