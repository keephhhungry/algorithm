package y2021.m08.d12;

import java.util.HashSet;

/**
 * @author ： cxyxh
 * @date : 8/12/2021 9:05 PM
 * @describetion :345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels {

    public static void main(String[] args) {
        String res = reverseVowels("hello");
        System.out.println(res);
    }

    /**
     * 双指针法
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] res = s.toCharArray();
        int left = 0;
        int right = res.length - 1;
        while (left < right) {
            while (left < right && !set.contains(res[left])) {
                left++;
            }
            while (left < right && !set.contains(res[right])) {
                right--;
            }
            if (left < right) {
                char c = res[left];
                res[left] = res[right];
                res[right] = c;
                right--;
                left++;
            }
        }

        return String.valueOf(res);
    }
}
