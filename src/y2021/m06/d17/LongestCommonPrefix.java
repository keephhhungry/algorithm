package y2021.m06.d17;

/**
 * @author ： cxyxh
 * @date : 2021/6/17 23:32
 * @describetion : leetcode编号14-最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String result = method1(strs);
        //System.out.println("最长公共前缀为:[" + result + "]");
        result = method2(strs);
        System.out.println("最长公共前缀为:[" + result + "]");
    }

    /**
     * 横向扫描法
     * // TODO
     * @param strs 判断数组
     * @return 最长前缀
     */
    public static String method1(String[] strs) {
        String result = "";

        return result;
    }

    /**
     * 纵向扫描法
     * 时间复杂度：O(MN)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * 空间复杂度：O(1)。
     *
     * @param strs 判断数组
     * @return 最长前缀
     */
    public static String method2(String[] strs) {
        // 如果数组为null或者数组的长度为0，返回""
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            int length = strs[0].length();
            int count = strs.length;
            for (int i = 0; i < length; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < count; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
        }
        return strs[0];
    }
}
