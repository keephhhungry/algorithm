package y2021.m09.d11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 9/11/2021 9:36 AM
 * @describetion :401. 二进制手表
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class ReadBinaryWatch {

    public static void main(String[] args) {
        List<String> res = readBinaryWatch(3);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     *
     * @param turnedOn
     * @return
     */
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                // 查找1的个数
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
