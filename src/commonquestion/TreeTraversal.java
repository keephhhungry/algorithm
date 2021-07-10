package commonquestion;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 2021/6/27 1:23
 * @describetion : 中序遍历
 */
public class TreeTraversal {

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
        /**
         * 树节点如下
         *                 1
         *               /   \
         *             2      3
         *           /      /   \
         *         4      5      6
         *       /  \      \
         *      7    8      9
         * root = [1,2,3,4,5,6,7,8,9]
         */
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));

        List<Integer> preRes = new ArrayList<>();
        preRes = PreorderTraversal(root, preRes);
        // 1 2 4 7 8 3 5 9 6
        System.out.println("前序遍历的结果为：" + preRes.toString());

        List<Integer> inRes = new ArrayList<>();
        inRes = inorderTraversal(root, inRes);
        // 7 4 8 2 1 5 9 3 6
        System.out.println("中序遍历的结果为：" + inRes.toString());

        List<Integer> postRes = new ArrayList<>();
        postRes = PostorderTraversal(root, postRes);
        // 7 8 4 2 9 5 6 3 1
        System.out.println("后序遍历的结果为：" + postRes.toString());
    }

    /**
     * 前序遍历：遍历顺序为 根节点，左子节点，右子节点
     *
     * @param root
     * @param res
     * @return
     */
    public static List<Integer> PreorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        res.add(root.val);
        PreorderTraversal(root.left, res);
        PreorderTraversal(root.right, res);
        return res;
    }

    /**
     * 中序遍历：遍历顺序为 左子节点，根节点，右子节点
     *
     * @param root
     * @param res
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
        return res;
    }

    /**
     * 后序遍历：遍历顺序为 左子节点，右子节点，根节点
     *
     * @param root
     * @param res
     * @return
     */
    public static List<Integer> PostorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        PostorderTraversal(root.left, res);
        PostorderTraversal(root.right, res);
        res.add(root.val);
        return res;
    }

}
