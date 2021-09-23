package y2021.m09.d24;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 9/24/2021 12:14 AM
 * @describetion :976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * <p>
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestPerimeter {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 2, 3};
        int res = largestPerimeter(nums);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];
            if (method(a, b, c)) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static boolean method(int a, int b, int c) {
        return a + b > c;
    }
}
