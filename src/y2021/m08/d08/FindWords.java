package y2021.m08.d08;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ： cxyxh
 * @date : 8/8/2021 8:56 AM
 * @describetion :500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWords {


    public static void main(String[] args) {
        String[] words = new String[]{"Aasdfghjkl", "Qwertyuiop", "zZxcvbnm"};
        String[] ans = findWords(words);
        System.out.println(Arrays.toString(ans));
    }

    public static String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);

        String[] ans = new String[words.length];
        int index = 0;
        for (String word : words) {
            if (word.length() == 1) {
                ans[index++] = word;
            }
            for (int i = 0; i < word.length() - 1; i++) {
                if (map.get(word.toLowerCase().charAt(i)) != map.get(word.toLowerCase().charAt(i + 1))) {
                    break;
                }
                if (i == word.length() - 2) {
                    ans[index++] = word;
                }
            }
        }

        return Arrays.copyOfRange(ans, 0, index);
    }
}
