package zuo.level1.class7;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author ： cxyxh
 * @date : 2021/7/5 22:15
 * @describetion :是否是平衡树
 * 测试链接：https://leetcode.com/problems/balanced-binary-tree
 */
public class Code02_BalancedBinaryTree {

    /**
     * 树类
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 返回的信息类
     */
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    /**
     * 是否是平衡树
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    /**
     * 是否是平衡树的核心逻辑
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }

}
