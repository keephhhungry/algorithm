package commonquestion;

import java.nio.file.AtomicMoveNotSupportedException;

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

        int index1 = bigThanTargetMostLeft(nums, 3);
        System.out.println("大于3的最左边的角标为：[" + index1 + "]");

        int index2 = smallThanTargetMostRight(nums, 3);
        System.out.println("小于3的最右边的角标为：[" + index2 + "]");
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

    /**
     * 从有序数组中找到>=target最左的位置
     * 本质与二分法相同，不同的是，如果中点大于等于目标值(符合题意)，就把答案记录下来，由于要找最坐的位置，所以我去掉右边的部分，让right=mid-1,找寻更符合答案的角标
     * 如果中点小于目标值，那么去掉左边的部分，从右边继续二分
     * @param nums
     * @return
     */
    public static int bigThanTargetMostLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    /**
     * 从有序数组中找到<=target最右的位置
     * 本质与二分法相同，不同的是，如果中点小于等于目标值(符合题意)，就把答案记录下来，由于要找最右的位置，所以我去掉左边的部分，让left=mid+1,找寻更符合答案的角标
     * 如果中点大于目标值，那么去掉右边的部分，从左边继续二分
     * @param nums
     * @return
     */
    public static int smallThanTargetMostRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
