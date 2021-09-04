package zuo.level3.class3;

/**
 * @author ： cxyxh
 * @date : 9/4/2021 10:32 AM
 * @describetion :求arr中的最大值
 * <p>
 * Master公式(分析递归函数的时间复杂度)
 * T(N) = a * T(N/b) = O (N^d)
 * a,b,d常数
 * a:调用次数
 * b:子问题规模
 * d:除了递归的复杂度
 * <p>
 * 子问题的规模是相同的可以用Master公式
 * <p>
 * 1) log b a < d   O(N^d)
 * 2) log b a > d   O(N^(log b a))
 * 3) log b a ==d   O((N ^ d) * log N)
 */
public class Code08_GetMax {

    // 求arr中的最大值
    public static int getMax(int[] arr) {
        return procss(arr, 0, arr.length);
    }

    // arr[L..R] 范围上求最大值 L ... R
    // 时间复杂度T(N) = 2 * T(N/2) + O(1)
    // 递归的复杂度 加上 除了递归意外的复杂度
    public static int procss(int[] arr, int L, int R) {
        // arr[L..R]范围上只有一个数，直接返回，base case
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = procss(arr, L, mid);
        int rightMax = procss(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

}
