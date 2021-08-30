package zuo.level3.class1;

/**
 * @author ： cxyxh
 * @date : 8/30/2021 5:11 PM
 * @describetion : 局部最小值。
 * 如果1角标的值大于0角标的值，那么0就是局部最小值
 * 如果N-2角标的值大于N-1角标的值，那么N-1就是局部最小值
 * 如果非两边，中间角标i，如果i-1和i+1角标的值都大于i角标的值，那么i就是局部最小值
 */
public class Code07_BSAwesome {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        // 如果只有一个数，那么它就是局部最小值
        if (n == 1) {
            return 0;
        }
        // 如果1角标的值大于0角标的值，那么0就是局部最小值
        if (arr[0] < arr[1]) {
            return 0;
        }
        // 如果N-2角标的值大于N-1角标的值，那么N-1就是局部最小值
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        // 如果上述左右两边的条件都没有命中，说明左右两边的趋势如下
        // \      /
        //  \    /
        while (left < right) {
            int mid = (left + right) / 2;
            // 头      中间    尾巴
            //  \       /       /
            //   \     /       /
            // 说明局部最小值在头部和中间 之间
            if (arr[mid] > arr[mid - 1]) {
                mid = right - 1;
            } else if (arr[mid] < arr[mid - 1]) {
                mid = left + 1;
            } else {
                return mid;
            }

        }
        return left;
    }
}
