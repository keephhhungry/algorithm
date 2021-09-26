package y2021.m09.d26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 9/26/2021 3:38 PM
 * @describetion :589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class Preorder {

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

    ;

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

        List<Integer> res = preorder(root);
        res.stream().forEach(System.out::print);
    }

    /**
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        return process(root, res);
    }

    public static List<Integer> process(Node root, List<Integer> res) {
        if (root == null) {
            res.add(null);
            return res;
        }
        res.add(root.val);
        for (int i = 0; root.children != null && i < root.children.size(); i++) {
            process(root.children.get(i), res);
        }
        return res;
    }


}
