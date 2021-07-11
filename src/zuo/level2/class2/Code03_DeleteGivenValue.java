package zuo.level2.class2;

/**
 * @author ： cxyxh
 * @date : 2021/7/11 11:13
 * @describetion : 从链表中删除给定的数
 */
public class Code03_DeleteGivenValue {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先定义一个pre节点和next节点。
     * 1.先把head的下一个节点地址赋给next节点(为了地址不丢)；
     * 2.把pre赋给head的下一个值(反转)
     * 3.把head值赋给pre(pre后移一位)
     * 4.把next值赋给head(next后移一位)
     * @param head
     * @return
     */
    public static Node removeValue(Node head) {
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
        head = removeValue(head);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
    
}
