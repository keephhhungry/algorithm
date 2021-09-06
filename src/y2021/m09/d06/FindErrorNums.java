package y2021.m09.d06;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 9/6/2021 11:14 PM
 * @describetion :645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindErrorNums {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};
        int[] res = findErrorNums(nums);
        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur == pre) {
                res[0] = pre;
            } else if (cur - pre > 1) {
                res[1] = pre + 1;
            }
            pre = cur;
        }
        if (nums[n - 1] != n) {
            res[1] = n;
        }
        return res;
    }
}
