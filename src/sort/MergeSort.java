package sort;

import java.util.Arrays;

/**
 * <p>
 * 归并排序
 * </p>
 *
 * @author zhangyu
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println("merge sort: " + Arrays.toString(array));
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;

        sort(array, left, middle);
        sort(array, middle + 1, right);

        merge(array, left, right, middle);
    }

    private void merge(int[] array, int left, int right, int middle) {
        int[] tempArray = new int[right - left + 1];

        // 临时数组下标
        int k = 0; 
        int l = left;
        int r = middle + 1;

        // 当任意子数组遍历完终止循环
        while (l <= middle && r <= right) {
            // 如果第一个数组的元素 大于 第二个数组，将第二个数组元素添加到临时数组
            if (array[l] >= array[r]) {
                tempArray[k] = array[r];
                k++;
                r++;
            } else {
                tempArray[k] = array[l];
                k++;
                l++;
            }
        }

        // 判断哪个子数组还有剩余的数据
        int start = l;
        int end = middle;
        if (r <= right) {
            start = r;
            end = right;
        }
        // 将子数组剩余的数据拷贝到临时数组
        while (start <= end) {
            // 当前的临时数组和 剩余的子数组都是有序的，直接追加就好
            tempArray[k] = array[start];
            k++;
            start++;
        }

        // 将临时数组中的数据拷贝回原数组
        for (int i = 0; i < tempArray.length; i++) {
            array[i + left] = tempArray[i];
        }
    }


}
