package zuo.level3.class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ： cxyxh
 * @date : 8/31/2021 10:19 PM
 * @describetion :
 */
public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    // 自己实现双端队列
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        // 从头部添加
        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            // 如果头结点为空，那么该节点就是头节点和尾结点
            if (head == null) {
                head = cur;
                tail = cur;
                // 如果头结点不为空，插入节点的下一个节点指针指向原先的头结点；原先的头节点的上一个节点指针指向插入的节点；头结点指向要插入的节点
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        // 从尾部添加
        public void addFromBottom(T value) {
            Node<T> cur = new Node<T>(value);
            // 如果头结点为空，那么该节点就是头节点和尾结点
            if (head == null) {
                head = cur;
                tail = cur;
                // 如果头结点不为空(也就是尾结点不为空)
                // 插入节点的上一个指针指向尾结点；尾结点的下一个指针指向插入节点；尾结点指向要插入的节点
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        // 从头部弹出
        public T popFromHead() {
            // 如果头结点为空个，直接弹出空
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            // 如果头结点等于尾节点，相当于弹出了最后一个数据，头尾节点都置为空
            if (head == tail) {
                head = null;
                tail = null;
                // 如果头结点不等于尾结点，相当于还有数据
                // 头结点指向当前头结点的下一个节点；解除原先头节点和现在节点的关系(原先头结点的下一个节点指针置为空，现在头结点的上一个节点指针置为空)
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        // 从尾部弹出
        public T popFromBottom() {
            // 如果头结点为空个，直接弹出空
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            // 如果头结点等于尾节点，相当于弹出了最后一个数据，头尾节点都置为空
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                // 如果头结点不等于尾结点，相当于还有数据
                // 尾结点指向当前尾结点的上一个节点；解除原先尾节点和现在节点的关系(现在尾结点的下一个节点指针置为空，原先尾结点的上一个节点指针置为空)
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        // 是否为空
        public boolean isEmpty() {
            return head == null;
        }

    }

    // 自己写栈
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<T>();
        }

        // 栈的压入是压入头部
        public void push(T value) {
            queue.addFromHead(value);
        }

        // 栈的弹出是从头部弹出
        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    // 自己写队列
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<T>();
        }

        // 队列的添加是添加进头部(添加进尾部，从头部弹出也可以)
        public void push(T value) {
            queue.addFromHead(value);
        }

        // 从尾部弹出
        public T poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }

}
