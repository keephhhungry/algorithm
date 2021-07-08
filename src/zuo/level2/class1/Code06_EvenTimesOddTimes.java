package zuo.level2.class1;

/**
 * @author ： cxyxh
 * @date : 2021/7/8 22:06
 * @describetion :一个数组中有一种数出现了奇数次，其他数都出现了偶数次，找到这个数并打印这个数
 */
public class Code06_EvenTimesOddTimes {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 5, 5, 6};
        printOddTimesNums(arr);
    }

    public static void printOddTimesNums(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        System.out.println(ans);
    }
}
