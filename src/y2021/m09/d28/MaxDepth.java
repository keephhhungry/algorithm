package y2021.m09.d28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 9/28/2021 11:02 PM
 * @describetion :559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<Node>();

        Node second1 = new Node(3);
        Node second2 = new Node(2);
        Node second3 = new Node(4);
        root.children.add(second1);
        root.children.add(second2);
        root.children.add(second3);

        Node third1 = new Node(5);
        Node third2 = new Node(6);
        second1.children = new ArrayList<Node>();
        second1.children.add(third1);
        second1.children.add(third2);

        int res = maxDepth(root);
        System.out.println(res);
    }

    public static int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        int result = 1;
        for (Node child : root.children) {
            result = Math.max(result, 1 + maxDepth(child));
        }
        return result;
    }
}
