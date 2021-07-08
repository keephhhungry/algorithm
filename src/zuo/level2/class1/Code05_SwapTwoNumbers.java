package zuo.level2.class1;

/**
 * @author ： cxyxh
 * @date : 2021/7/8 21:59
 * @describetion : 在不占用额外空间的情况下，交换两个数
 * 异或 相同为0，不同为1  可以理解成无进位相加
 * 同或 不同为1，相同为0
 *
 * 0 ^ N == N;
 * N ^ N == 0;
 *
 * 异或运算满足交换律和结合律
 */
public class Code05_SwapTwoNumbers {

    public static void main(String[] args) {
        int a = 5;
        int b = 20;

        // a = a ^ b ; b = b;
        a = a ^ b;
        // a = a ^ b ; b = a ^ b ^ b = a
        b = a ^ b;
        // a = a ^ b ^ b = a ; b = a
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
