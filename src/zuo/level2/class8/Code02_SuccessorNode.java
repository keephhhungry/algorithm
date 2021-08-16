package zuo.level2.class8;

/**
 * @author ： cxyxh
 * @date : 7/27/2021 8:11 PM
 * @describetion :找到某个节点的后继节点。中序遍历的下一个节点
 */
public class Code02_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 分为两种情况
     * 1.如果该节点有右树，那么去找右树的最左节点
     * 2.如果该节点没有右树，那么找到他的父节点，并且该父节点并他父节点的右节点
     *
     *                 1
     *              /    \
     *             2      3
     *           /  \    /  \
     *          4    5  6    7
     *                \
     *                 8
     *                  \
     *                   9
     *  中序遍历： 4 2 5 8 9 1 6 3 7
     *  如果是5，那么找5的右树的最左节点，如果没有的话，那么就是5的右树是后继节点。
     *  如果是9，那么9没有右树，往上找8是5的右树，5是2的右树，2是1的左树，所以1是9的后继节点
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        // 如果该节点有右子树，那么后继节点一定在右子树的最左子树上
        if (node.right != null) {
            return getLeftMost(node);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 获取某个节点的最左子树
     *
     * @param node
     * @return
     */
    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }

}
