package y2021.m06.d27;

/**
 * @author ： cxyxh
 * @date : 2021/6/27 11:49
 * @describetion :leetcode编号70. 爬楼梯
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        ListNode listNode = deleteDuplicates(head);
    }

    /**
     * 一次遍历
     * <p>
     * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
     * 具体地，我们从指针ur 指向链表的头节点，随后开始对链表进行遍历。如果当前 cur 与 cur.next 对应的元素相同，那么我们就将 cur.next 从链表中移除；
     * 否则说明链表中已经不存在其它与cur 对应的元素相同的节点，因此可以将cur 指向cur.next。
     * 当遍历完整个链表之后，我们返回链表的头节点即可。
     * <p>
     * 细节
     * 当我们遍历到链表的最后一个节点时，cur.next 为空节点，如果不加以判断，访问cur.next 对应的元素会产生运行错误。因此我们只需要遍历到链表的最后一个节点，而不需要遍历完整个链表。
     * <p>
     * 时间复杂度：O(n)，其中 n 是链表的长度。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return head;
    }
}
