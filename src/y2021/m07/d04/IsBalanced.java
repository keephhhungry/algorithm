package y2021.m07.d04;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 23:29
 * @describetion :leetcode编号110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsBalanced {

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

    /**
     * 定义信息类，拥有两个属性。1是否平衡，当前高度
     */
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        boolean ans = isBalanced(node);
        System.out.println(ans);
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
     * 核心逻辑层
     * @param root
     * @return
     */
    public static Info process(TreeNode root) {
        // 如果当前节点是null，那么当前节点是平衡的，并且高度是0
        if (root == null) {
            return new Info(true, 0);
        }
        // 拿到当前节点的左子节点的情况
        Info leftInfo = process(root.left);
        // 拿到当前节点的右子节点的情况
        Info rightInfo = process(root.right);
        // 获取当前节点的高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 拿到当前左子节点的平衡情况，右子节点的平衡情况以及 左右节点的高度是否小于2
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        // 返回当前信息
        return new Info(isBalanced, height);
    }
}
