package y2021.m07.d26;

import org.omg.Messaging.SyncScopeHelper;

import java.lang.reflect.Parameter;
import java.util.HashMap;

/**
 * @author ： cxyxh
 * @date : 7/26/2021 11:22 PM
 * @describetion :leetcode编号290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        boolean ans = wordPattern(pattern, str);
        System.out.println(ans);
    }

    /**
     * 双哈希表
     * <p>
     * 分别把pattern的每个字符和对应的每个字符串存入双哈希表，key和value对调
     * 在每次插入的时候，两个哈希表都判断是否加入过，如果没有则插入，如果有则看看和之前存入的value是否对应
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = arr[i];
            if (map1.containsKey(c) && !map1.get(c).equals(arr[i])) {
                return false;
            }
            if (map2.containsKey(s) && map2.get(s) != c) {
                return false;
            }
            map1.put(c, s);
            map2.put(s, c);
        }
        return true;
    }
}
