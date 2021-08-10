package y2021.m08.d10;

/**
 * @author ： cxyxh
 * @date : 8/10/2021 10:41 PM
 * @describetion : 704. 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int res = search(nums, 5);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
