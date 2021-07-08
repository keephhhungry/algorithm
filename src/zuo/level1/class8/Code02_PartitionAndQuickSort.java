package zuo.level1.class8;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 23:26
 * @describetion : 快速排序
 */
public class Code02_PartitionAndQuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 递归方法
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalE = partition(arr, L, R);
        // 对左边进行排序
        process(arr, L, equalE[0] - 1);
        // 对右边进行排序
        process(arr, equalE[1] + 1, R);
    }

    /**
     * 实际的排序方法
     *
     * 方法原则
     * 如果当前数小于划分值，那么当前数与小于区的下个数做交换，小于区右扩，当前数+1；
     * 如果当前数大于划分值，那么当前数与大于区的前一个数交换，大于区做扩，当前数不变;
     * 如果当前数等于划分值，当前数+1;
     *
     *
     * 小于区域           大于区域
     *  | 3 6 2 4 4 7 1 5 | 4
     *
     * 第一轮：拿3和4做比较,3小于4，3和3做交换，小于区右扩，当前数+1；
     *  3 | 6 2 4 4 7 1 5 | 4
     * 第二轮：拿6和4做比较,6大于4，6和5做交换，大于区左扩，当前数不变;
     *  3 | 5 2 4 4 7 1 | 6 4
     * 第四轮：拿5和4做比较,5大于4，5和1做交换，大于区左扩，当前数不变;
     *  3 | 1 2 4 4 7 | 5 6 4
     * 第五轮：拿1和4做比较,1小于4，1和1做交换，小于区右扩，当前数+1；
     *  3 1 | 2 4 4 7 | 5 6 4
     * 第六轮：拿2和4做比较,2小于4，2和2做交换，小于区右扩，当前数+1；
     *  3 1 2 | 4 4 7 | 5 6 4
     * 第七，八轮：拿4和4做比较,4等于，当前数+1；
     *  3 1 2 | 4 4 7 | 5 6 4
     * 第九轮：拿7和4做比较,7大于4，7和7做交换，大于区左扩，当前数不变;
     *  3 1 2 | 4 4 | 7 5 6 4
     *
     *  此时当前数和大于区撞上了，进行最后一轮，让当前数和最后一个数做交换
     *  3 1 2 4 4 4 5 6 7
     *  此时将数组分为三层，左边小于4，中间等于4，右边大于4
     *
     *  方法最后返回数组，数组的第一个值是小于区的边界+1，第二个值是大于区的边界
     *  其实就是中间层的头尾角标
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] partition(int[] arr, int L, int R) {
        // 右边的最后一个数设为比较数字，所以左边的边界是L-1，右边的边界为R
        int lessR = L - 1;
        int moreL = R;
        // 起步比较值为L
        int index = L;
        // 当起步比较值 小于 右边界
        while (index < moreL) {
            // 如果当前值小于比较值，那么当前值和比较值
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[] { lessR + 1, moreL };
    }

    /**
     * 交换方法
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
