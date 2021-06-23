package y2021.m06.d23;

/**
 * @author ： cxyxh
 * @date : 2021/6/23 23:20
 * @describetion :leetcode编号35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6};
        int target = 1;
        int index = searchInsert(nums, target);
        System.out.println("角标为:[" + index + "]");

    }

    /**
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param nums   数组
     * @param target 目标值
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        // 默认是插在最后一位，如果循环过程中没有一个值比目标值大，那么自然是插在最后一位
        int result = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 如果比较的值比目标值来的大，如比较值5，目标值4。那么目标值4暂时应该排在比较值5的位置。
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
