package y2021.m06.d24;

/**
 * @author ： cxyxh
 * @date : 2021/6/24 0:52
 * @describetion :leetcode编号58. 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World   ";
        int length = lengthOfLastWord(s);
        System.out.println("最后一个单词的长度为为:[" + length + "]");
    }

    /**
     * 从后往前遍历
     * 时间复杂度：O(n)，n为结尾空格和结尾单词总体长度
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int end = s.length() - 1;
        // 从后往前遍历，找到第一个不是' '的角标  end = 10;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        // 如果从后往前遍历到小于0角标，那么说明字符串全部都是' '，直接返回0
        if (end < 0) {
            return 0;
        }
        int start = end;
        // 继续往前遍历，找到下一个是' '角标  start = 5;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        // 两者角标差就是结果
        return end - start;
    }
}
