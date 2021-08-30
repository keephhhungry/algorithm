package y2021.m08.d30;

/**
 * @author ： cxyxh
 * @date : 8/30/2021 11:37 PM
 * @describetion :520. 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * 输入: "USA"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: "FlaG"
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCapitalUse {


    public static void main(String[] args) {
        boolean res = detectCapitalUse("Google");
        System.out.println(res);
        System.out.println("a=" + (int) 'a');//97
        System.out.println("z=" + (int) 'z');//122
        System.out.println("A=" + (int) 'A');//65
        System.out.println("Z=" + (int) 'Z');//90
    }

    /**
     * @param word
     * @return
     */
    public static boolean detectCapitalUse(String word) {
        int n = word.length();
        int z = 0;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) z++;
        }
        if (z == n || (word.charAt(0) >= 65 && word.charAt(0) <= 90 && z == 1) || z == 0) return true;
        return false;
    }
}
