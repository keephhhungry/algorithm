package zuo.level2.class12;

import java.util.Stack;

/**
 * @author ： cxyxh
 * @date : 8/14/2021 10:26 AM
 * @describetion : 给你一个栈，逆序装入另外一个栈，不允许引入其他的数据结构容器，用递归的方法实现
 */
public class Code03_ReverseStackUsingRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    // 栈底元素移除掉
    // 上面的元素盖下来
    // 返回移除掉的栈底元素
    public static int f(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = f(stack);
            stack.push(res);
            return last;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        //test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }
}
