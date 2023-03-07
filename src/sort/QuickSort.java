package sort;

import java.util.Arrays;

/**
 * <p>
 * 快速排序
 * </p>
 *
 * @author zhangyu
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println("quick sort: " + Arrays.toString(array));
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
//        int pivot = partition2(array, left, right);

        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        // 选择分区点（可以是任意一个元素）
        int pivot = left;
        int index = left + 1;

        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                index++;
            }
        }

        int temp = array[pivot];
        array[pivot] = array[index - 1];
        array[index - 1] = temp;
        return index - 1;
    }

    private int partition2(int[] array, int left, int right) {
        int pivot = array[left];
        int index = left;

        while (right > left) {

            while (right > left) {
                if (array[right] < pivot) {
                    array[left] = array[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }

            while (right > left) {
                if (array[left] > pivot) {
                    array[right] = array[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }

        }
        array[index] = pivot;
        return index;
    }


}
