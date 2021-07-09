package y2021.m07.d09;

/**
 * @author ： cxyxh
 * @date : 2021/7/9 22:37
 * @describetion :leetcode编号171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TitleToNumber {

    public static void main(String[] args) {
        int number = titleToNumber("AB");
        System.out.println(number);

    }

    /**
     * 最右侧的数字减去'A'的大小再加1 最后乘以1
     * 倒二右侧的数字减去'A'的大小再加1 最后乘以1*26
     * 倒三右侧的数字减去'A'的大小再加1 最后乘以1*26*26
     *
     * 时间复杂度：O(n)，其中 n 是列名称columnTitle 的长度。需要遍历列名称一次。
     * 空间复杂度：O(1)。
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        int num = 0;
        int a = 1;
        int index = columnTitle.length()-1;
        while (index >= 0) {
            char c = columnTitle.charAt(index);
            num = num + (c - 'A' + 1) * a;
            index--;
            a = 26 * a;
        }
        return num;
    }
}
