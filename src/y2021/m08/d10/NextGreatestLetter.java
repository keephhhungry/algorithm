package y2021.m08.d10;

/**
 * @author ： cxyxh
 * @date : 8/10/2021 10:57 PM
 * @describetion :744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * 示例：
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *  
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char res = nextGreatestLetter(letters, 'k');
        System.out.println(res);
    }

    /**
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (letters[mid] > target) {
                res = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
