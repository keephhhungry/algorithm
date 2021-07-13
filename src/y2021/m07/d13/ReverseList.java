package y2021.m07.d13;

import java.util.List;

/**
 * @author ： cxyxh
 * @date : 2021/7/13 23:15
 * @describetion :leetcode编号206. 反转链表
 * 你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node = reverseList(node);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    /**
     * 思路：创建一个'前节点'和'后节点'
     * 1. 当节点不为空的时候，先把当前节点的后一个地址赋给'后节点'
     * 2. 把'前节点'赋给当前节点的后一个地址
     * 3. 把当前节点赋给'前节点'
     * 4. 把'后节点'赋给当前节点
     * <p>
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
