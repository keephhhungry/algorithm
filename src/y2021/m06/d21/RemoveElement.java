package y2021.m06.d21;

/**
 * @author ： cxyxh
 * @date : 2021/6/21 23:59
 * @describetion : leetcode编号27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * <p>
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3, 4, 5};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println("删除元素的长度为:[" + i + "]");
    }

    /**
     * 双指针法
     * 时间复杂度：O(n)，其中 n 为序列的长度。我们只需要遍历该序列至多两次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 双指针优化法
     * 时间复杂度：O(n)，其中 n 为序列的长度。我们只需要遍历该序列至多一次。
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
