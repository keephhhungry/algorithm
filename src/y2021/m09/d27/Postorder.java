package y2021.m09.d27;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 9/28/2021 10:27 PM
 * @describetion :590. N 叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class Postorder {

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

        List<Integer> res = postorder(root);
        // 5,6,3,2,4,1
        res.stream().forEach(System.out::print);
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null ){
            return res;
        }
        return process(root, res);
    }

    public static List<Integer> process(Node root, List<Integer> res) {
        if (res == null) {
            res.add(null);
            return res;
        }
        if (root.children != null) {
            for (int i = 0; i <= root.children.size() - 1; i++) {
                process(root.children.get(i), res);
            }
        }
        res.add(root.val);
        return res;
    }

}
