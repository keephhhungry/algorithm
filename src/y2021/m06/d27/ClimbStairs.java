package y2021.m06.d27;

/**
 * @author ： cxyxh
 * @date : 2021/6/26 12:04
 * @describetion :leetcode编号70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int i = climbStairs(6);
        System.out.println("共有[" + i + "]种爬楼梯的方式");
        i = climbStairs2(6);
        System.out.println("共有[" + i + "]种爬楼梯的方式");
    }

    /**
     * 动态规划
     * 思路： 每次只能爬一级或者两级台阶，所以爬上N级台阶的方法等于爬上N-1和N-2级台阶的和
     * 转换成公式如下 f(x) = f(n-1) + f(n-2);
     * 定义变量 f(0) = 1 ; f(1) = 1
     * f(2) = f(1) + f(0) = 2
     * f(3) = f(2) + f(1) = 3
     * f(4) = f(3) + f(2) = 5
     * f(5) = f(4) + f(3) = 8
     * f(6) = f(5) + f(4) = 13
     * 可以写一个for循环，从3开始循环，按照上述公式累加
     * 时间复杂度：O(n)，其中 n 是阶梯数。
     * 空间复杂度：O(n)。其中 n 是阶梯数。
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    /**
     * 动态规划
     * 思路： 每次只能爬一级或者两级台阶，所以爬上N级台阶的方法等于爬上N-1和N-2级台阶的和
     * 转换成公式如下 f(x) = f(n-1) + f(n-2);
     * 其中f(x) 记为r,初始值为1
     * f(n-1) 记为p,初始值为0
     * f(n-2) 记为q,初始值为0
     * <p>
     * f(1) =   p   q    r
     * 0   0    1
     * <p>
     * f(2) =   p   q    r
     * 1   1    2
     * <p>
     * f(3) =   p   q    r
     * 1   2    3
     * <p>
     * f(4) =   p   q    r
     * 2   3    5
     * <p>
     * f(5) =   p   q    r
     * 3   5    8
     * <p>
     * f(6) =   p   q    r
     * 8   13   21
     * <p>
     * 从上述可以得到规律，在x每次递增的时候，
     * 这一轮的p等于上一轮的q，
     * 这一轮的q等于上一轮的r，
     * 这一轮的r等于这一轮p与q的和
     * 是一个滚动数组的形式
     * <p>
     * 时间复杂度：O(n)，其中 n 是阶梯数。
     * 空间复杂度：O(1)。
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
