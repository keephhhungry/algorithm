package y2021.m09.d01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 9/1/2021 10:34 PM
 * @describetion :412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FizzBuzz {

    public static void main(String[] args) {
        List<String> list = fizzBuzz(3);
        list.stream().forEach(System.out::println);
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        HashMap<Integer, String> fizzBizzDict = new HashMap<Integer, String>();
        fizzBizzDict.put(3, "Fizz");
        fizzBizzDict.put(5, "Buzz");

        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";
            for (Integer key : fizzBizzDict.keySet()) {
                if (num % key == 0) {
                    numAnsStr += fizzBizzDict.get(key);
                }
            }
            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(num);
            }
            list.add(numAnsStr);
        }
        return list;
    }
}
