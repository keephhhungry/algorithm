package y2021.m06.d28;

/**
 * @author ： cxyxh
 * @date : 2021/6/28 22:36
 * @describetion :leetcode编号100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -10^4 <= Node.val <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSameTree {

    // TODO 广度优先搜索不会
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);

        p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        q = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }

    /**
     * 深度优先搜索
     * <p>
     * 思路：传入两个节点，如果两个节点都为空，那么他们是相等的返回true；
     *      如果只有一个节点为空，那么返回false
     *      如果都不为空，判断他们的值，如果他们的值不相等，那么返回false
     *      否则，判断他们的左子节点 && 右子节点的值 的结果
     *      只有存在一个节点不一致，那么最后的结果就是false
     * <p>
     * 时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点数。对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
     * 空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点数。空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }
}
