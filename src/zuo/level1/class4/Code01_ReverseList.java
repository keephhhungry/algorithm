package zuo.level1.class4;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 9:50
 * @describetion : 反转单向链表与双向链表
 */
public class Code01_ReverseList {

    /**
     * 定义单链表类
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 定义双链表类
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }


    /**
     * 反转单链表
     * head -> 3 -> 1 -> 2
     *
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        // 定义一个前节点和后节点
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 把当前节点的下一个节点赋值给next节点，保存好节点后。再把pre节点赋值给head的next节点
            next = head.next;
            head.next = pre;
            // pre 和 head 整体往后退一位，  让 head 赋给 pre，next 赋给 head
            pre = head;
            head = next;
            // 一次循环结束后，next 指向下一次要循环的head， pre 指向的是这一次循环的head。所以最后返回的是pre
        }
        return pre;
    }

    /**
     * 反转双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        // 定义一个前节点和后节点
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            // 把当前节点的下一个节点赋值给next节点，保存好节点后。再把pre节点赋值给head的next节点，把next节点赋值给head的last节点
            next = head.next;
            head.next = pre;
            head.last = next;
            // pre 和 head 整体往后退一位，  让 head 赋给 pre，next 赋给 head
            head = pre;
            head = next;
            // 一次循环结束后，next 指向下一次要循环的head， pre 指向的是这一次循环的head。所以最后返回的是pre
        }
        return pre;
    }

}
