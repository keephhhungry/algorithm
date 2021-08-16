package zuo.level2.class13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 8/14/2021 4:42 PM
 * @describetion :从左往右的尝试模型
 * 打印一个字符串的全部子序列
 * <p>
 * 打印一个字符串的全部子序列，要求不要出现重复字面值的子序列
 */
public class Code01_PrintAllSubsquences {

    /**
     * 打印s字符的全部子序列
     *
     * @param s
     * @return
     */
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    /**
     * @param str   输入的字符串
     * @param index 来到了str[index]字符，index是位置
     * @param ans   答案存储队列
     * @param path  str[0..index-1]已经走过了！之前的决定，都在path上
     */
    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        // 没有要index位置的字符
        process1(str, index + 1, ans, path);
        // 要了index位置的字符
        process1(str, index + 1, ans, path + String.valueOf(str[index]));
    }

    // 分界线，上面是全部子序列，下面是不重复的子序列

    /**
     * 要计算的字符串
     *
     * @param s
     * @return
     */
    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();
        process2(str, 0, set, path);
        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }

    public static void process2(char[] str, int index, HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        // 没有要index位置的字符
        process2(str, index + 1, set, path);
        // 要了index位置的字符
        process2(str, index + 1, set, path + String.valueOf(str[index]));
    }

    public static void main(String[] args) {
        String test = "acccc";
        List<String> ans1 = subs(test);
        List<String> ans2 = subsNoRepeat(test);

        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=================");
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=================");

    }
}
