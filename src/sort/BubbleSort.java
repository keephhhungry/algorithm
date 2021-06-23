package sort;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/6/22 23:17
 * @describetion : 冒泡排序
 * <p>
 * 简介：
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * <p>
 * 算法描述：
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；
 * 4. 重复步骤1~3，直到排序完成。
 * <p>
 * 稳定性：
 * 在相邻元素相等时，它们并不会交换位置，所以，冒泡排序是稳定排序。
 * <p>
 * 适用场景：
 * 冒泡排序思路简单，代码也简单，特别适合小数据的排序。但是，由于算法复杂度较高，在数据量大的时候不适合使用。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSortBetter(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 双重for循环，因为最后一个数值不需要判断，所以i < n-1
        for (int i = 0; i < n - 1; i++) {
            // 因为外层循环i次，后面i位都是排好序的，所以 i < n-i-1 多减1也是最后一个数值不用判断
            for (int j = 0; j < n - i - 1; j++) {
                // 如果前一位比后一位来的大，那么进行交换
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化版
     * 说明：如果本轮排序没有做任何的交换，说明数组已经是有序的，直接退出排序
     *
     * @param arr
     */
    public static void bubbleSortBetter(int[] arr) {
        int n = arr.length;
        boolean swap;
        for (int i = 0; i < n - 1; i++) {
            swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                    swap = true;
                }
            }
            // 如果本来排序没有任何交换，说明数组已经是有序的，直接退出排序
            if (!swap) {
                break;
            }
        }
    }

}
