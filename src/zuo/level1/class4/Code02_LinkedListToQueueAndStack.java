package zuo.level1.class4;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 10:20
 * @describetion : 单向链表构造队列及栈
 */
public class Code02_LinkedListToQueueAndStack {

    /**
     * 定义单链表类
     *
     * @param <V>
     */
    public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
            next = null;
        }
    }

    /**
     * 定义队列类
     *
     * @param <V>
     */
    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        /**
         * 判空方法
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 查看队列大小
         *
         * @return
         */
        public int size() {
            return size;
        }

        /**
         * 添加一个元素
         *
         * @param value
         */
        public void offer(V value) {
            Node<V> cur = new Node<V>(value);
            // 如果尾节点是空的，那么这是第一个元素，头节点和尾节点都是该节点
            if (tail == null) {
                head = cur;
                tail = cur;
                // 如果尾节点不为空，那么把该值赋给，当前尾节点的下一个节点，并且让该值成为尾节点
            } else {
                tail.next = cur;
                tail = cur;
            }
            //数组大小+1
            size++;
        }

        /**
         * 将首个元素从队列中弹出（ 移除并返回队列头部的元素 ）
         *
         * @return
         */
        public V poll() {
            V ans = null;
            // 如果头结点不是空，那么返回头结点；把头结点的下一个节点作为头结点；数组大小-1
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            // 如果头结点是空，那么尾节点也是空
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        /**
         * 展示最前端的节点值
         *
         * @return
         */
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

    }

    /**
     * 定义栈类
     * @param <V>
     */
    public static class MyStack<V> {
        private Node<V> head;
        private int size;

        public MyStack() {
            head = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        /**
         * 压栈
         * @param value
         */
        public void push(V value) {
            Node<V> cur = new Node<>(value);
            // 如果头部节点为空，那么传进来的值为头部节点
            if (head == null) {
                head = cur;
                // 如果头部节点不为空，让当前值的下一个值指向头结点；让当前值成为头结点
            } else {
                cur.next = head;
                head = cur;
            }
            size++;
        }

        /**
         * 出栈
         * @return
         */
        public V pop() {
            V ans = null;
            // 如果头结点不为空，那么返回头结点的值，并且把头结点的下一个值当做头结点
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }

        /**
         * 返回最上面的元素的值
         * @return
         */
        public V peek() {
            return head != null ? head.value : null;
        }

    }
}
