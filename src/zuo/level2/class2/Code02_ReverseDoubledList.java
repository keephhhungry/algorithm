package zuo.level2.class2;

/**
 * @author ： cxyxh
 * @date : 2021/7/11 11:13
 * @describetion : 单链表反转
 */
public class Code02_ReverseDoubledList {

    public static class Doublehead {
        public int value;
        public Doublehead last;
        public Doublehead next;

        public Doublehead(int data) {
            value = data;
        }
    }

    /**
     * 先定义一个pre节点和next节点。
     * 1.先把head的下一个节点地址赋给next节点(为了地址不丢)；
     * 2.把pre赋给head的下一个值(反转)
     * 3.把next复制head的上一个值(反转)
     * 4.把head值赋给pre(pre后移一位)
     * 5.把next值赋给head(next后移一位)
     * @param head
     * @return
     */
    public static Doublehead reverseDoubledList(Doublehead head) {
        Doublehead pre = null;
        Doublehead next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Doublehead head = new Doublehead(1);
        head.next = new Doublehead(2);
        head.next.next = new Doublehead(3);
        head = reverseDoubledList(head);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
    
}
