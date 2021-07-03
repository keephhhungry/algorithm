package y2021.m07.d03;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 22:31
 * @describetion :leetcode编号136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 4, 2, 1, 1, 3};
        int i = singleNumber(nums);
        System.out.println("只出现一次的数字是[" + i + "]");
    }

    public static int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
