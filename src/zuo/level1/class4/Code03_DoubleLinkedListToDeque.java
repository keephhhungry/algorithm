package zuo.level1.class4;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 11:25
 * @describetion : 双链表实现双端队列(可头进，头出，尾进，尾出)
 */
public class Code03_DoubleLinkedListToDeque {

    /**
     * 定义节点类
     * @param <V>
     */
    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V v) {
            value = v;
            last = null;
            next = null;
        }
    }

    /**
     * 定义队列类
     * @param <V>
     */
    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyDeque() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        /**
         * 从头部插入
         * @param value
         */
        public void pushHead(V value) {
            Node<V> cur = new Node<>(value);
            // 如果头部节点为空，那么该节点是第一个节点，该节点的头结点和尾结点都是该节点
            if (head == null) {
                head = cur;
                tail = cur;
                // 如果不是，那么插入的节点要被当做头结点。需要把当前节点的尾指针指向当前头结点，当前头结点的头指针指向当前节点，并且把当前节点作为头结点
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        /**
         * 从尾部插入
         * @param value
         */
        public void pushTail(V value) {
            Node<V> cur = new Node<>(value);
            // 如果头部节点为空，那么该节点是第一个节点，该节点的头结点和尾结点都是该节点
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                // 如果不是，那么插入的节点要被当做尾结点。需要把尾结点的尾指针指向当前节点，把当前节点的头指针指向尾节点，并且把当前节点赋给尾节点
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
            size++;
        }

        /**
         * 从头部出
         * @return
         */
        public V pollHead() {
            V ans = null;
            // 如果头结点为空，那么队列为空
            if (head == null) {
                return ans;
            }
            size--;
            // 要返回的节点
            ans = head.value;
            // 如果头结点等于尾结点，说明队列已经空了
            if (head == tail) {
                head = null;
                tail = null;
                // 否则头结点的下一个节点为头结点；此时头结点已经是下一个原先头结点的下一个节点了，再把当前头结点的头指针赋值null，这样原先的头结点就不可达了，会被JVM回收
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        /**
         * 从尾部出
         * @return
         */
        public V pollTail() {
            V ans = null;
            // 如果头结点为空，那么队列为空
            if (head == null) {
                return ans;
            }
            size--;
            // 要返回的节点
            ans = tail.value;
            // 如果头结点等于尾结点，说明队列已经空了
            if (head == tail) {
                head = null;
                tail = null;
                // 否则把当前尾结点的头指针指向尾结点，并且把更新后的尾结点尾指针指向null，这样原先的尾结点就不可达了，会被JVM回收
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        /**
         * 返回头结点的值
         * @return
         */
        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        /**
         * 返回尾结点的值
         * @return
         */
        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }

    }


}
