package y2021.m07.d14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： cxyxh
 * @date : 2021/7/14 22:56
 * @describetion :leetcode编号219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int target = 1;
        boolean ans = containsNearbyDuplicate(nums, target);
        System.out.println(ans);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (Math.abs(map.get(nums[i]) - i)) <= target) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
