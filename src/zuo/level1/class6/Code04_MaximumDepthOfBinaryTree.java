package zuo.level1.class6;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 11:56
 * @describetion : 查询树的最大深度
 * 测试链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Code04_MaximumDepthOfBinaryTree {

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

        int i = maximumDepthOfBinaryTree(node1);
        System.out.println(i);
    }

    public static int maximumDepthOfBinaryTree(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maximumDepthOfBinaryTree(node.left), maximumDepthOfBinaryTree(node.right)) + 1;
    }
}
