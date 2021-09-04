package zuo.level3.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ： cxyxh
 * @date : 9/4/2021 10:15 AM
 * @describetion :两个队列实现栈
 * 1.一个队列是主队列，一个是辅助队列
 * 2.压入数据全部压入主队列中
 * 3.弹出的时候，把主队列的数据全部加到辅助队列中，只剩下最后一个，然后弹出，模拟栈后进先出的特点 。然后再交换两个队列的数据
 */
public class Code07_TwoQueueImplementStack {


    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        // 压入数据
        public void push(T value) {
            queue.offer(value);
        }

        // 弹出数据
        public T poll() {
            // 弹出前把queue的数据导出到help队列中，只剩下最后一个
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            // 弹出queue的最后一个数据，模拟栈后进先出的特点
            T ans = queue.poll();
            // 因为queue的数据全部都清空了，所以交换queue和help队列的数据，复原queue的数据
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;

            return ans;
        }

        // 返回最前端的值，与poll同理
        public T peek() {
            // 弹出剩下最后一个数据
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            // 弹出最后一个值
            T ans = queue.poll();
            // 由于是peek，所以不能真的弹出，所以弹出后再加到help队列中
            help.offer(ans);
            // 交换队列
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        // 判断是否为空
        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }


    public static void main(String[] args) {
        System.out.println("test begin");
        TwoQueueStack<Integer> myStack = new TwoQueueStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }
}
