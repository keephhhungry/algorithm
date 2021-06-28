package commonquestion;

/**
 * @author ： cxyxh
 * @date : 2021/6/27 1:22
 * @describetion : 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 8, 9, 12, 34, 76};
        int target = 2;
        int i = binarySearch(nums, target);
        System.out.println("target所在的位置为：[" + i + "]");
    }

    /**
     * 经典二分查找
     *
     * @param nums
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
