package y2021.m08.d07;

/**
 * @author ： cxyxh
 * @date : 8/7/2021 9:12 AM
 * @describetion :495. 提莫攻击
 * <p>
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * <p>
 * 示例1:
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 * <p>
 * 示例2:
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。
 *  
 * 提示：
 * <p>
 * 你可以假定时间序列数组的总长度不超过 10000。
 * 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/teemo-attacking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPoisonedDuration {

    public static void main(String[] args) {
        int[] timeSeries = new int[]{1, 4};
        int second = findPoisonedDuration(timeSeries, 4);
        System.out.println(second);
    }

    /**
     * 如果a[j] + duration <= a[j+1]  那么持续时间为 duration
     * 如果a[j] + duration > a[j+1] 那么持续时间为 a[j+1] - a[j]
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) {
            return 0;
        }
        int second = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration <= timeSeries[i + 1]) {
                second += duration;
            } else {
                second += timeSeries[i + 1] - timeSeries[i];
            }
        }
        // 最后一次攻击时间持续满的
        return second + duration;
    }
}
