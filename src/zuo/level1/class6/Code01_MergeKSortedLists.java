package zuo.level1.class6;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 10:23
 * @describetion :leetcode编号23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code01_MergeKSortedLists {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] lists = {n1, n2, n3};
        ListNode listNode = mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }

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

    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    /**
     * 合并多个升序数组
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        // 如果数组为null，直接返回null
        if (lists == null) {
            return null;
        }
        //  创建一个优先队列，并指定比较器(小的在前)，把每个数组的头结点都放进
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        //  如果队列为空，直接返回null
        if (heap.isEmpty()) {
            return null;
        }
        // 首先确定头结点为队列中的第一个值(最小值)
        ListNode head = heap.poll();
        // 把头结点的内存地址给pre， 用于后续计算，head用于返回
        ListNode pre = head;
        // 由于head已经被拿到了，所以队列中需要拿pre的下一个数去补充
        if (pre.next != null) {
            heap.add(pre.next);
        }
        // 如果队列不为空，那么把持续把队列head中的数添加到pre链表中，并且往head中补充该节点的下一个值
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }


}
