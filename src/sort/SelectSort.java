package sort;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/6/22 23:53
 * @describetion : 选择排序
 * <p>
 * 简介：
 * 选择排序是一种简单直观的排序算法，它也是一种交换排序算法，和冒泡排序有一定的相似度，可以认为选择排序是冒泡排序的一种改进。
 * <p>
 * 算法描述
 * 1. 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2. 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3. 重复第二步，直到所有元素均排序完毕。
 * <p>
 * 稳定性：
 * 用数组实现的选择排序是不稳定的，用链表实现的选择排序是稳定的。
 * 不过，一般提到排序算法时，大家往往会默认是数组实现，所以选择排序是不稳定的。
 * <p>
 * 适用场景：
 * 选择排序实现也比较简单，并且由于在各种情况下复杂度波动小，
 * 因此一般是优于冒泡排序的。在所有的完全交换排序中，选择排序也是比较不错的一种算法。
 * 但是，由于固有的O(n^2)复杂度，选择排序在海量数据面前显得力不从心。因此，它适用于简单数据排序。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 每一轮的第一个数字默认为最小
            int min = i;
            for (int j = i + 1; j < n; j++) {
                // 如果后续的值比最小值还小，记住对应角标，并对拿来比较的最小值进行替换
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
