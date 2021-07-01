package y2021.m07.d01;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 2021/7/1 21:41
 * @describetion :leetcode编号118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Generate {

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)。不考虑返回值的空间占用。
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // 传入的数字是多少，则循环多少次
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            // 在第几行，就循环多少次
            for (int j = 0; j <= i; j++) {
                //如果是第一位或者最后一位，那么直接添加1
                if (j == 0 || j == i) {
                    tmp.add(1);
                    // 如果在中间，则是上面一个集合的 对应角标 和 对应角标-1 相加的和
                } else {
                    tmp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
