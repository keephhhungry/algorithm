package y2021.m09.d18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： cxyxh
 * @date : 9/18/2021 10:26 AM
 * @describetion :
 */
public class FindLHS {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3,};
        int res = findLHS(nums);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num) + map.get(num - 1));
            }
            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }
        }
        return res;
    }
}
