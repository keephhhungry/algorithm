package y2021.m07.d01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 2021/7/1 22:45
 * @describetion :leetcode编号119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 解释：
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 从0开始计算行数
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Generate2 {

    public static void main(String[] args) {
        List<Integer> list = getRow(5);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)。不考虑返回值的空间占用。
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // 这里是一个需要理解的数学公式
            /**
             * [1],
             * [1,1],
             * [1,2,1],
             * [1,3,3,1],
             * [1,4,6,4,1]
             *
             * 第rowIndex行，第i位的值  等于 （该rowIndex行的i-1位的值 乘以  rowIndex行-i位+1) 除以 i 位
             * 例： 4 = 1*(4-1+1)/1
             *     6 = 4*(4-2+1)/2
             *
             */
            list.add((int) ((long) list.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return list;
    }

}
