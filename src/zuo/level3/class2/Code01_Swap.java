package zuo.level3.class2;

/**
 * @author ： cxyxh
 * @date : 8/30/2021 6:15 PM
 * @describetion :通过 ^ 运算交换两个数
 */
public class Code01_Swap {

    public static void main(String[] args) {
        int a = 10;
        int b = 100;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
