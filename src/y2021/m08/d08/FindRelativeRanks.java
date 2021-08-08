package y2021.m08.d08;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 8/8/2021 9:13 AM
 * @describetion :506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRelativeRanks {

    public static void main(String[] args) {
        int[] score = new int[]{5, 3, 4, 2, 1};
        String[] ans = findRelativeRanks(score);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param score
     * @return
     */
    public static String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) {
            return null;
        }
        // 拷贝数组到score1，并排序
        int n = score.length;
        int[] score1 = new int[score.length];
        System.arraycopy(score, 0, score1, 0, n);
        Arrays.sort(score1);

        // 遍历原数组，从拷贝数组中取出排序的角标，判断名次
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            // 通过二分查找，获取元素在排好序的数组中的角标
            int index = Arrays.binarySearch(score1, score[i]);
            if (index == n - 1) ans[i] = "Gold Medal";
            else if (index == n - 2) ans[i] = "Silver Medal";
            else if (index == n - 3) ans[i] = "Bronze Medal";
            else ans[i] = n - index + "";
        }
        return ans;
    }
}
