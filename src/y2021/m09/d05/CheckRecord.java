package y2021.m09.d05;

/**
 * @author ： cxyxh
 * @date : 9/5/2021 10:56 PM
 * @describetion :551. 学生出勤记录 I
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * 示例 2：
 * <p>
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckRecord {

    public static void main(String[] args) {
        String s = "PPALLP";
        boolean res = checkRecord(s);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param s
     * @return
     */
    public static boolean checkRecord(String s) {
        int aNum = 0;
        int continuousLNum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                aNum++;
                continuousLNum = 0;
                // 如果超出限制，提前结束判断
                if (aNum >= 2) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                continuousLNum++;
                // 如果超出限制，提前结束判断
                if (continuousLNum >= 3) {
                    return false;
                }
            } else {
                continuousLNum = 0;
            }
        }
        return true;
    }
}
