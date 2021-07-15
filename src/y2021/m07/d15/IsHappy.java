package y2021.m07.d15;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ： cxyxh
 * @date : 2021/7/15 22:16
 * @describetion :leetcode编号202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *  
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsHappy {

    public static void main(String[] args) {
        boolean happy1 = isHappy1(19);
        System.out.println(happy1);
        boolean happy2 = isHappy2(19);
        System.out.println(happy2);
    }

    /**
     * 方法1
     * 时间复杂度O(logn)
     * 空间复杂度O(logn)
     *
     * @param n
     * @return
     */
    public static boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        // n不等于1 并且 不包含值
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * 方法2 快慢指针
     * 循环条件：快的不等于1 并且快的值不等于慢的值
     * 时间复杂度O(logn)
     * 空间复杂度O(logn)
     *
     * @param n
     */
    public static boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
