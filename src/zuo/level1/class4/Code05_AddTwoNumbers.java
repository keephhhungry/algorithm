package zuo.level1.class4;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 12:03
 * @describetion :按要求合并两个链表，要求如下
 *
 * 链表A 1 -> 2 ->3    链表B 3 -> 4 -> 5
 * 321+543 = 468
 * 返回链表 4 -> 6 -> 8
 *
 *
 * 测试链接：https://leetcode.com/problems/add-two-numbers/
 */
public class Code05_AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 按要求合并两个链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 计算两个链表的长度
        int len1 = listLength(head1);
        int len2 = listLength(head2);
        // 长的链表设为l，短的链表设为s
        ListNode l = len1 >= len2 ? head1 : head2;
        ListNode s = l == head1 ? head2 : head1;
        // 把长短链表的头结点，赋值给curL和curS用于下面做计算
        ListNode curL = l;
        ListNode curS = s;
        // 把长链表的头节点，赋给last，用于下面做计算
        ListNode last = curL;
        // 是否进一
        int carry = 0;
        // 对10取余
        int curNum = 0;
        // 第一阶段，两个链表都有值
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        // 第二阶段，只有长链表有值
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        // 第三阶段，长短链表都没有值 ，判断是否有进制位1
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return l;
    }

    /**
     * 求链表长度
     * @param head
     * @return
     */
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
