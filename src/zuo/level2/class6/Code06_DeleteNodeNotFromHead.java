package zuo.level2.class6;

/**
 * @author ： cxyxh
 * @date : 7/26/2021 2:08 PM
 * @describetion :给定节点，从链表中删除该节点
 */
public class Code06_DeleteNodeNotFromHead {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node cur = node;
        while (cur != null) {
            System.out.print(cur.value);
            cur = cur.next;
        }
        System.out.println();
        deleteNode(node2);
        cur = node;
        while (cur != null) {
            System.out.print(cur.value);
            cur = cur.next;
        }
    }

    /**
     * 该方法属于投机取巧
     * 坏处如下
     * 1.属于替代内容，本质上并没有删掉该节点，删除的是该节点的下一个节点
     * 2.如果内容复杂，拷贝方法无法调用，那么无法删除
     * 3.无法删除最后一个节点
     *
     * @param node
     */
    public static void deleteNode(Node node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
