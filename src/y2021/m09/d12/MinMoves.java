package y2021.m09.d12;

/**
 * @author ： cxyxh
 * @date : 9/12/2021 6:56 PM
 * @describetion :453. 最小操作次数使数组元素相等
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 * <p>
 * 示例：
 * 输入：
 * [1,2,3]
 * 输出：
 * 3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinMoves {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int res = minMoves(nums);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 其他所有的数都减一，等于自身+1
     *
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }
        return res;
    }
}
