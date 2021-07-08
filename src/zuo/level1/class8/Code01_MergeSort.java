package zuo.level1.class8;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 19:33
 * @describetion : 归并排序
 */
public class Code01_MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 递归方法实现
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，请让这个范围上的数，有序！

    /**
     *                                  f(0,0)
     *                          f(0,1)
     *                        /         f(1,1)
     *                  f(0,3)
     *                  /     \         f(2,2)
     *                 /        f(2,3)
     *                /                 f(3,3)
     *          f(0,7)
     *           /    \                 f(4,4)
     *          /      \        f(4,5)
     *         /        \     /         f(5,5)
     *        /          f(4,7)
     *       /                \         f(6,6)
     *      /                   f(6,7)
     *     /                            f(7,7)
     * f(0,14)
     *     \
     *      \
     *       \                          f(8,8)
     *        \                  f(8,9)
     *         \                 /      f(9,9)
     *          \        f(8,11)
     *           \         /     \      f(10,10)
     *            \       /      f(10,11)
     *             \     /              f(11,11)
     *           f(8,14)
     *                \
     *                 \                f(12,12)
     *                  \        f(12,13)
     *                   \     /        f(13,13)
     *                    f(12,14)
     *                         \
     *                            f(14,14)
     *
     *  如上图所示：
     *      该数组首次进来的L=0,R=14,第一次确定mid=7，进入第一次递归，此时进来的L=0,R=7。mid=3，再次进入递归
     *      层层递归，直到f(0,1) L=0,R=1，mid=0的时候。此时递归进来，进入的两次process递归方法全部直接返回。进入merge方法，merge方法把0,1范围上的数字按顺序排列
     *      该递归返回后，会进入f(2,3) L=2,R=3,mid=2的时候，此时递归进来，进入的两次process递归方法全部直接返回。进入merge方法，merge方法把2，,3范围上的数字按顺序排列
     *      该递归返回后，会进入f(0,3) L=0,R=3,mid=2的时候，此时是递归出来，所以进入merge方法，merge方法把0，,3范围上的数字按顺序排列
     *      以此类推，直到整个数组有序
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        // 如果排序的范围只有一个数，那么直接返回
        if (L == R) {
            return;
        }
        // 找到中点
        int mid = L + ((R - L) >> 1);
        // 对左边的范围进行确定
        process(arr, L, mid);
        // 对右边的范围进行确定
        process(arr, mid + 1, R);
        // 确定好范围，开始排序
        merge(arr, L, mid, R);
    }

    /**
     * @param arr 数组
     * @param L   左边角标
     * @param M   中点角标
     * @param R   右边角标
     */
    public static void merge(int[] arr, int L, int M, int R) {
        // 创建一个辅助数组
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        // 左边的数组是L~M 右边的数组是M+1~R。如果p1不越界，并且p2不越界的话，
        // 如果p1的值比p2小，那么把p1的值加到help数组中，p1++,i++;如果p1的值比p2大，那么把p2的值加到help数组中，p2++,i++;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界，要么p2越界
        // 不可能出现：共同越界,没有越界的半边把剩下的数传完
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 因为只需要排序L~R，最后把辅助数组的值从L+0开始添加到arr数组中
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

}
