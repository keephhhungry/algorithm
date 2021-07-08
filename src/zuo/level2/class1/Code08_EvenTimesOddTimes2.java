package zuo.level2.class1;

/**
 * @author ： cxyxh
 * @date : 2021/7/8 22:09
 * @describetion :一个数组中有两种数出现了奇数次，其他数都出现了偶数次，找到并打印这两种数
 */
public class Code08_EvenTimesOddTimes2 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 5, 5, 6, 7};
        printOddTimesNums(arr);
    }

    /**
     * 思路：假设一个数a为6，一个数b为7
     * 先遍历数组，全部 ^ 过去  ans = a ^ b
     *  a = 0 0 1 1 0
     *  b = 0 0 1 1 1
     *  a ^ b  = 0 0 0 0 1;
     * a 和 b 至少有一位，在这一位上一个数是0，一个数是1，我们找到这一位数，假设为2
     * 找到ans的最右边的1。
     * <p>
     * 此时整个数组分为第2为是0的，以及第二位是1的
     * 我们把第二位是1的，全部 ^ 到一起，可以得到第2位是0，且只出现一次的数字
     * 把ans ^ 该数字 得到另一个只出现一次的数字
     *
     * @param arr
     */
    public static void printOddTimesNums(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        // 提取最右的1
        int rightOne = ans & (~ans + 1);
        int ans2 = 0;
        // 把最右是1的数全部放在一起 ^ , 得到最右是1的其中一个数
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                ans2 ^= arr[i];
            }
        }
        // 原先的ans是两个数 ^ 的结果，再 ^ 上其中一个数，答案就是另外一个数
        ans = ans ^ ans2;
        System.out.println(ans + ", " + ans2);
    }
}
