package sort;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/6/24 0:11
 * @describetion : 插入排序
 * <p>
 * 简介：
 * 插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * <p>
 * 算法描述：
 * 1. 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
 * 2. 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
 * 3. 重复上述过程直到最后一个元素被插入有序子数组中。
 * <p>
 * 稳定性：
 * 由于只需要找到不大于当前数的位置而并不需要交换，因此，直接插入排序是稳定的排序方法。
 * <p>
 * 适用场景：
 * 插入排序由于O(n2)的复杂度，在数组较大的时候不适用。
 * 但是，在数据比较少的时候，是一个不错的选择，一般做为快速排序的扩充。
 * 例如，在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序。
 * 又如，在JDK 7 java.util.Arrays所用的sort方法的实现中，当待排数组长度小于47时，会使用插入排序。
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void InsertionSort(int[] arr) {
        int n = arr.length;
        // 总的排序次数
        for (int i = 1; i < n; i++) {
            // 记下当前角标的值
            int value = arr[i];
            // 记下当前角标
            int position = i;
            // 如果角标大于0，并且该角标值大于开始记录的比较值
            while (position > 0 && arr[position - 1] > value) {
                // 那么把角标的前一个值给后一个值（类似于数字向后挪动一格）
                arr[position] = arr[position - 1];
                // 并且角标-1
                position--;
            }
            // 最后把备份的值，赋值给对应角标的数值
            arr[position] = value;
        }
    }
}
