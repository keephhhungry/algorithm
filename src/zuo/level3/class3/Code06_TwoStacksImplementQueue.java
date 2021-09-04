package zuo.level3.class3;

import java.util.Stack;

/**
 * @author ： cxyxh
 * @date : 9/4/2021 10:08 AM
 * @describetion :使用两个栈完成实现队列功能
 * 一个栈用来压入，一个栈用来弹出。
 * 1.压入的时候正常压入 压入栈
 * 2.弹出的时候，查看弹出栈是否为空，如果为空，那么从压入栈导入数据过来，否则直接弹出弹出栈的数据。
 *
 * 代码每次操作前都去检查是否可以从压入栈导入数据，十分好理解
 */
public class Code06_TwoStacksImplementQueue {

    public static class TwoStacksQueue {
        // 压入栈
        public Stack<Integer> stackPush;
        // 弹出栈
        public Stack<Integer> stackPop;

        //push栈向pop栈导入数据
        private void pushToPop() {
            // 如果弹出栈为空，那么才从压入栈导入弹出栈
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        // 队列添加，加的时候操作压入栈，操作完检查是否可以压入弹出栈
        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        // 队列弹出。弹出操作的是弹出栈
        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        // 返回队列最前面的值，操作的是弹出栈
        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public static void main(String[] args) {
            TwoStacksQueue test = new TwoStacksQueue();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
        }
    }
}
