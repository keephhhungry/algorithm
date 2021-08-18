package y2021.m08.d18;

/**
 * @author ： cxyxh
 * @date : 8/18/2021 10:29 PM
 * @describetion :383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanConstruct {

    public static void main(String[] args) {
        String ransom = "aa";
        String magazine = "aab";
        boolean res = canConstruct(ransom, magazine);
        System.out.println(res);

    }

    /**
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     *
     * @param ransom
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransom, String magazine) {
        if (ransom.length() > magazine.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            arr[c - 'a'] = arr[c - 'a'] + 1;
        }
        for (int i = 0; i < ransom.length(); i++) {
            char c = ransom.charAt(i);
            if (arr[c - 'a'] == 0) {
                return false;
            }
            arr[c - 'a'] = arr[c - 'a'] - 1;
        }
        return true;
    }
}
