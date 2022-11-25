package sort;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangyu
 */
public class SortTests {

    public static void main(String[] args) {
        int[] array = {2,1,5,3,4,9,6,8,7};
        Sort sort;
//        sort = new BubbleSort();
//        sort = new InsertSort();
//        sort = new SelectionSort();
//        sort = new MergeSort();
        sort = new QuickSort();
        
        sort.sort(array);

        removeDuplicates();
    }


    public static int removeDuplicates() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (n < 2 || nums[i] > nums[n - 2]) {
                nums[n++] = nums[i];
            }
        }
        int[] targetNums = new int[n];
        System.arraycopy(nums, 0, targetNums, 0, n);
        System.out.println(Arrays.toString(nums));
        
        System.out.println(Arrays.toString(targetNums));
        return n;
    }
    
}
