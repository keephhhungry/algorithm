package zuo.level2.class6;

/**
 * @author ： cxyxh
 * @date : 7/26/2021 10:07 AM
 * @describetion :把单项链表按某值划分成左边小，中间相等，右边大的形式
 * 1. 把链表放入数组里， 在数组上做partition(笔试用)
 * 2. 分成小、中、大三部分，再把各个部分之间串起来(面试用)
 */
public class Code03_SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 放进数组里
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        // 遍历链表元素个数
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        // 创建数组，把链表元素装入数组
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 对数组做一个划分
        arrPartition(nodeArr, pivot);
        // 把数组用链表串起来
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    /**
     * 对数组做一个划分，小于目标值的在左边，等于的在中间，大于的在右边
     *
     * @param nodeArr
     * @param pivot
     */
    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    /**
     * 直接用链表串起来 面试用
     *
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition2(Node head, int pivot) {
        // 定义三个区的6个节点
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node
        // 把三个链表分成 小于区，等于区，大于区。每个区有头尾节点
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        //把三个区的头尾节点串起来，小于区域的尾巴，连等于区域的头，等于区域的尾巴连接大于区域的头
        // 如果有小于区域，小于区域的尾巴连接等于区域的头，等于区域的尾巴如果是空，小于区域的尾巴给它
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // 如果等于区域不为空，等于区域的尾巴连接大于区域的头
        if (eT != null) {
            eT.next = mH;
        }
        // 如果小于区的头不为空，返回小于区的头；等于区的头不为空，返回等于区的头，大于区的头不为空，返回大于区的头
        return sH != null ? sH : (eH != null ? eH : mH);
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 5);
        printLinkedList(head1);
        head1 = listPartition2(head1, 6);
        printLinkedList(head1);

    }

}
