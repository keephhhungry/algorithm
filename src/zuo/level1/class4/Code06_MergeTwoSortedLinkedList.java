package zuo.level1.class4;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 12:19
 * @describetion :合并两个有序链表
 * 测试链接：https://leetcode.com/problems/merge-two-sorted-lists
 */
public class Code06_MergeTwoSortedLinkedList {

    /**
     * 链表类
     */
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
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // 如果有一个链表为空，那么返回另外一个链表即可
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // 判断哪个链表的头结点较小，把较小的结点当做最重要返回的头结点
        ListNode head = head1.val <= head2.val ? head1 : head2;
        // 拿到头结点的下一个值
        ListNode cur1 = head.next;
        // 拿到另一个链表的下一个值
        ListNode cur2 = head == head1 ? head2 : head1;
        // 因为head结点要拿来返回不懂，所以生成pre结点替代head结点
        ListNode pre = head;
        // 如果两个链表都不为空
        while (cur1 != null && cur2 != null) {
            // 如果1结点小于等于2结点，那么1结点排在pre结点之后，并且让cur1.next=cur1，继续接下来的运算
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
                // 如果1结点大于2结点，那么2结点排在pre结点之后
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            // 更新完pre的next结点后，pre要替换成pre.next结点，继续接下来的运算
            pre = pre.next;
        }
        // pre.next 等于两个链表中不为空的那个结点
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

}
