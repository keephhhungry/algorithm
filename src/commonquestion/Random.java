package commonquestion;

/**
 * @author ： cxyxh
 * @date : 2021/6/30 23:47
 * @describetion : 关于随机数的题目
 */
public class Random {

    public static final String PARTING = "=======================================\r\n";
    public static final int TEST_TIMES = 10000;

    public static void main(String[] args) {
        System.out.println("将0~1的概率从线性变成x^2开始");
        int count = 0;
        double x = 0.7;
        for (int i = 0; i < TEST_TIMES; i++) {
            if (xToXPow2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) TEST_TIMES);
        System.out.println(Math.pow(x, 2));
        System.out.println("将0~1的概率从线性变成x^2结束");
        System.out.println(PARTING);


        System.out.println("通过黑盒函数f5,随机生成1~5的的数字，改造随机生成1~7的函数开始");
        int[] counts = new int[8];
        for (int i = 0; i < TEST_TIMES; i++) {
            counts[f7()]++;
        }
        for (int i = 1; i < counts.length; i++) {
            System.out.println(i + "出现的次数为" + counts[i]);
        }
        System.out.println("通过黑盒函数f5,随机生成1~5的的数字，改造随机生成1~7的函数结束");
        System.out.println(PARTING);


        System.out.println("通过黑盒函数q1,不等概率生成1或者0的函数开始");
        counts = new int[2];
        for (int i = 0; i < TEST_TIMES; i++) {
            counts[q1Answer()]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + "出现的次数为" + counts[i]);
        }
        System.out.println("通过黑盒函数q1,不等概率生成1或者0的函数结束");
        System.out.println(PARTING);

    }

    //===========将0~1的概率从线性变成x^2开始===========

    /**
     * 任意的x，x属于[0,x)范围上的数出现的概率由原来的x调整成x平方
     *
     * @return
     */
    public static double xToXPow2() {
        return Math.max(Math.random(), Math.random());
    }
    //===========将0~1的概率从线性变成x^2结束===========


    //===========通过黑盒函数f5,随机生成1~5的的数字，改造随机生成1~7的函数开始===========

    /**
     * 黑盒函数：等概率生成1~5的随机数
     *
     * @return
     */
    public static int f5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 通过 等概率生成1~5的黑盒函数f5 生成1~7的函数
     * 思路：第一步，将黑盒函数概率切割改造成随机生成0和1的函数。如黑盒函数的范围是1~5，则生成0，1返回0,生成3，4返回1，生成2要求重新生成
     * 第二步：将要生成的整体范围-1；如1~7，想象成(0~6)+1,一定要是(0~x)+m的格式,再想6需要几个二进制位来表示，如果是3位，那么调用第一步的函数，生成每一个二进制位的数字
     * 第三步：通过第二步计算的二进制位，通过无法刚好符合条件要求的区间。如3个二进制位表示0~7，而我们的目标是(0~6)+1,那么第三步就是执行第二步的函数，如果返回7，那么重新调用第二步的函数。最后返回ans+1
     *
     * @return
     */
    public static int f7() {
        return process3();
    }

    /**
     * 通过f5函数，等概率生成0和1
     *
     * @return
     */
    public static int process1() {
        int ans = 0;
        do {
            ans = f5();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 把生成1~7的思路转换成生成(0~6) +1
     * 骚操作重点!!! 6需要3个二进制位表示
     * 得到000~111 做到等概率,实际就是0~7等概率返回
     *
     * @return
     */
    public static int process2() {
        return (process1() << 2) + (process1() << 1) + (process1() << 0);
    }

    /**
     * 如果生成7，则重新调用process2方法，最后返回ans+1
     *
     * @return
     */
    public static int process3() {
        int ans = 0;
        do {
            ans = process2();
        } while (ans == 7);
        return ans + 1;
    }
    //===========通过黑盒函数f5,随机生成1~5的的数字，改造随机生成1~7的函数结束===========


    //===========通过黑盒函数q1,不等概率生成1或者0的函数开始===========
    /**
     * 黑盒函数q1,不等概率生成1或者0
     */
    public static int q1() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     * 通过q1函数等概率返回0和1；
     * @return
     */
    public static int q1Answer(){
        int ans = 0;
        // 如果你第一次和第二次返回值相同，那么重新调用方法
        // 生成1,1；0,0的概率不可控都不要
        // 生成1,0；0,1的概率是相等的，由此等概率获得0,1
        do{
            ans = q1();
        }while (ans == q1());
        return ans;
    }
    //===========通过黑盒函数q1,不等概率生成1或者0的函数开始===========
}
