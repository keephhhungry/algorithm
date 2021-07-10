package zuo.level1.class5;

import java.util.HashSet;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 15:46
 * @describetion : 数据结构 ->图
 * 原理：long有64位 分别是0~63  哪一位上的二进制数为1，则表示这个数字存在
 * 数组的第二位表示的是 64~127  同理哪一位的二进制数位，则表示这个数字存在
 * 以此类推
 */
public class Code01_BitMap {

    public static class BitMap {

        private long[] bits;

        /**
         * 构造方法，初始化图数组的长度
         * >>6的含义是 除以2^6
         * (max+64) >>6 可转换成 max/64 +64/64 = max/64+1;
         *
         * 当我们初始化max=0的时候，数组大小为1
         * 当我们初始化max=63的时候，数组大小为1
         * 当我们初始化max=64的时候，数组大小为2
         * @param max
         */
        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        /**
         * 添加：添加的数字在对应数组角标的对应二进制位上变成1
         * bits[num >> 6]:可以得出对应的数组角标
         *
         * num & 63： 等于把num /64 取余数
         * 如num = 1  0 0 0 0 0 1
         *       63  1 1 1 1 1 1
         *  num & 63 = 1；
         * 如num = 64  1 0 0 0 0 0 0
         *        63    1 1 1 1 1 1
         *  num & 63 = 0；
         *
         *  1L << (num & 63) ：上一步是取余数，这一步是把余数放到对应的位置上，表示存在
         *
         *  |= 由于是|,而右边已经为1，所以实现添加功能
         *
         * @param num
         */
        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        /**
         * 添加：添加的数字在对应数组角标的对应二进制位上变成0
         *
         * (1L << (num & 63)) 是把对应位置变成1
         * ~(1L << (num & 63)) 则是把对应位置变成0
         *
         * &= 由于是&,而右边已经为0，所以实现删除功能
         *
         * @param num
         */
        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        /**
         * 存有数据的数组 & 应该存放的位置
         * 右边一定为1，左边如果为1，表示存在。
         * 所以 存有数据的数组 & 应该存放的位置  !=0 就是存在
         * @param num
         * @return
         */
        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }

    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.delete(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
}
