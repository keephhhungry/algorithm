package y2021.m07.d04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 23:53
 * @describetion :leetcode编号145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), new TreeNode(8)), null),
                new TreeNode(3, new TreeNode(5, null, new TreeNode(9)), new TreeNode(6)));

        List<Integer> list = postorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "");
        }
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root, list);
        return list;
    }

    public static void process(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        process(root.left, list);
        process(root.right, list);
        list.add(root.val);
    }
}
