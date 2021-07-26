package y2021.m07.d26;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 7/26/2021 11:03 PM
 * @describetion :leetcode编号283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 如数组 3 0 2 0 1
     * 定义一个 i 和 j 都指向 0 处
     * 如果 i 位置不是 0 ，那么把 i 角标的数字 覆盖到 j 角标上。两个角标都 + 1 , 指向 0 处
     * 如果 i 位置是 0 ， 那么 j 角标不动 ， i 角标继续向后移动
     * 以此类推，i 源源不断的往后遍历，j会在0处停下来，把 i 指向的不是 0 的数覆盖本来是 0 值的 j角标数
     * 最后不是零的数字停在j角标，最后差值补0
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        // 遍历移动，i遍历把不是0的数覆盖到j上
        for (i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 差值部分补0
        for (i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
