package zuo.level1.class6;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 11:55
 * @describetion : 判断是否是镜像树
 * 测试链接：https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Code03_SymmetricTree {

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
        node1.right = new Node(2);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        node1.right.left = new Node(5);
        node1.right.right = new Node(4);

        boolean ans = isSymmetricTree(node1, node1);
        System.out.println(ans);
    }

    public static boolean isSymmetricTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.value == node2.value && isSymmetricTree(node1.left, node2.right) && isSymmetricTree(node1.right, node2.left);
        }
    }
}
