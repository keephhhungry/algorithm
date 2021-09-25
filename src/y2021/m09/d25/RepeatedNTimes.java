package y2021.m09.d25;

/**
 * @author ： cxyxh
 * @date : 9/25/2021 11:22 PM
 * @describetion :961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 5, 3, 2};
        int res = repeatedNTimes(nums);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int repeatedNTimes(int[] nums) {
        for (int k = 1; k <= 3; ++k) {
            for (int i = 0; i < nums.length - k; ++i) {
                if (nums[i] == nums[i + k]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
