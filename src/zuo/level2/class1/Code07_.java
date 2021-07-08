package zuo.level2.class1;

/**
 * @author ： cxyxh
 * @date : 2021/7/8 22:10
 * @describetion : 提取int类型的数，最右侧的1
 *
 *          N = 0 ..... 0 1 1 0 1 0 1 0 0 0
 *         ~N = 1 ..... 1 0 0 1 0 1 0 1 1 1
 *       ~N+1 = 1 ..... 1 0 0 1 0 1 1 0 0 0
 * N & (~N+1) = 1 ..... 0 0 0 0 0 0 1 0 0 0
 */
public class Code07_ {

    public static void main(String[] args) {
        int num  = 5;
        num = num & (~num +1);
        intSwitchToBinary(num);
        bitCounts(5);
    }

    public static void intSwitchToBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? '0' : '1');
        }
    }

    public static void bitCounts(int num) {
        int count = 0;
        while (num != 0) {
            // 获取1
            int rightOne = num & (~num + 1);
            count++;
            // 把最右侧的1消掉
            num ^= rightOne;
        }
        System.out.println(count);
    }
}
