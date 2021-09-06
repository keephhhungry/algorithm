package y2021.m09.d04;

/**
 * @author ： cxyxh
 * @date : 9/4/2021 10:30 PM
 * @describetion :541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseStr {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseStr(s, k);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            // 右边界值和数组最大角标取小值
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    // 区间反转
    public static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
