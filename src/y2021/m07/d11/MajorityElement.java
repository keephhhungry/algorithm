package y2021.m07.d11;

/**
 * @author ： cxyxh
 * @date : 2021/7/11 20:56
 * @describetion :leetcode编号169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    /**
     * 投票法
     *
     * 候选人(candNum)初始化为nums[0]，票数count初始化为1。
     * 当遇到与candNum相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，candNum即为最终答案。
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> [ n/2 ]，其余元素的个数总和<= [ n/2 ]。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 1;
        int candNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candNum == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candNum = nums[i];
                }
            }
        }
        return candNum;
    }
}
