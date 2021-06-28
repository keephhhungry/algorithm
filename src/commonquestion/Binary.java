package commonquestion;

/**
 * @author ： cxyxh
 * @date : 2021/6/28 22:19
 * @describetion : 二进制相关入门题
 */
public class Binary {

    public static void main(String[] args) {
        intSwitchToBinary(1);
    }


    /**
     * 把int类型的数字转换成二进制
     * <p>
     * 思路：用到了 & 符号  &符号当 0 & 1 = 0 ；0 & 0 = 0 ； 1 & 1 = 1；
     * int底层是由32位来存储，我们对32位逐一做对比。
     * 将 1 左移 x 位，保证 x 位是1，与num的 x 位做对比
     * 由 & 的性质可知 如果答案是0，说明num的 x 位是0；如果答案是1，说明num的 x 位 是1；
     *
     * @param num
     */
    public static void intSwitchToBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? '0' : '1');
        }
    }
}
