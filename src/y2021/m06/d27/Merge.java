package y2021.m06.d27;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/6/27 12:02
 * @describetion : leetcode编号88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6, 7};
        int n = 4;
        merge(nums1, m, nums2, n);
        System.out.println("合并后的数组为：" + Arrays.toString(nums1));
    }

    /**
     * 逆向双指针
     * <p>
     * 思路：拿两个数组的最后一个元素p1,p2，做对比，较大的元素放到数组1的最后一位tail。刚刚有移动的数组对应的比较长度-1
     * 如果其中一个数组已经比较完毕，那么直接移动另外一个数组的最后一位到数组1的最后一位
     * <p>
     * 时间复杂度：O(m+n)。 指针移动单调递减，最多移动 m+nm+n 次，因此时间复杂度为 O(m+n)O(m+n)。
     * 空间复杂度：O(1)原地修改，不需要额外空间。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        // 只要有一个数组还没有遍历完，则继续遍历
        while (p1 >= 0 || p2 >= 0) {
            // 如果nums1数组已经比较完毕
            if (p1 == -1) {
                cur = nums2[p2--];
                // 如果nums2数组已经比较完毕
            } else if (p2 == -1) {
                cur = nums1[p1--];
                // 如果nums1数组的最后一位小于num2数字的最后一位，那么移动num2数组
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums2[p2--];
                // 否则移动num1数组
            } else {
                cur = nums1[p1--];
            }
            // 对最后一位进行赋值
            nums1[tail--] = cur;
        }
    }
}
