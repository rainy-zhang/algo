package sort;

import java.util.Arrays;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author zhangyu
 */
public class SelectionSort implements Sort {
    
    @Override
    public void sort(int[] array) {
        int min, temp;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        System.out.println("selection sort: " + Arrays.toString(array));
        
    }
    
}
