package zuo.level2.class2;

/**
 * @author ： cxyxh
 * @date : 2021/7/11 11:13
 * @describetion :
 */
public class Code01_ReverseLinkedList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }


    /**
     * 先定义一个pre节点和next节点。
     * 1.先把head的下一个节点地址赋给next节点(为了地址不丢)；
     * 2.把pre赋给head的下一个值(反转)
     * 3.head(pre后移一位)
     * 4.把next值赋给head(next后移一位)
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head = reverseLinkedList(head);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
