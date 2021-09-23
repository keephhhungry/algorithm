package y2021.m09.d23;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 9/23/2021 8:28 PM
 * @describetion :922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 7};
        int[] res = sortArrayByParityII(nums);
        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];
        int even = 0;
        int odd = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                arr[even] = num;
                even += 2;
            } else {
                arr[odd] = num;
                odd += 2;
            }
        }
        return arr;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * i 表示偶数位， j 表示奇数位。
     * 如果 i 的偶数位有不是偶数的数字，那么在 j 的奇数位置上找不是奇数的数字 ，进行交换
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII2(int[] nums) {
        int n = nums.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
