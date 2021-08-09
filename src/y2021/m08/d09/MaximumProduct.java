package y2021.m08.d09;

/**
 * @author ： cxyxh
 * @date : 8/9/2021 9:17 PM
 * @describetion :628. 三个数的最大乘积
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * <p>
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumProduct {

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 2, 3, 4};
        int[] nums = new int[]{-1, -2, -3};
        int res = maximumProduct(nums);
        System.out.println(res);
    }

    /**
     * 如果全部是正数或者全部是负数，那么3个数的最大乘积是 最大的三个数的乘积
     * 如果有正数有负数，那么3个数的最大乘积是 最小的两个数和最大的数
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        // 最小的数min1 , 倒二小的数 min2
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // 最大的数max1 , 第二大的数max2 , 第三大的数max3
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
