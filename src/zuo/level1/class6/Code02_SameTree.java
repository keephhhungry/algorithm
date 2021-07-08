package zuo.level1.class6;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 11:55
 * @describetion : 判断是否是同一棵树
 * 测试链接：https://leetcode-cn.com/problems/same-tree/
 */
public class Code02_SameTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        node1.right.left = new Node(6);
        node1.right.right = new Node(7);

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.right = new Node(5);
        node2.right.left = new Node(6);
        node2.right.right = new Node(7);

        boolean ans = isSameTree(node1, node2);
        System.out.println(ans);
    }

    /**
     * 判断是否是同一棵树
     *
     * @param node1
     * @param node2
     * @return
     */
    public static boolean isSameTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.value == node2.value && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        }
    }

}
