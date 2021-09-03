package zuo.level3.class2;

/**
 * @author ： cxyxh
 * @date : 8/30/2021 6:16 PM
 * @describetion :
 * 1.在一个数组中，只有一个数字出现了奇数次，其他数字出现了偶数次
 * 2.在一个数组中，有两个数字出现了奇数次，其他数字出现了偶数次
 */
public class Code02_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // 提取最右边的1
        int rightOne = eor & (-eor);

        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            // 这里等于或者不等于无所谓，只是做区分
            if ((arr[i] & rightOne) == 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3};
        printOddTimesNum1(arr1);

        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 5};
        printOddTimesNum2(arr2);
    }
}
