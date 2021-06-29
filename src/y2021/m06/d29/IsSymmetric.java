package y2021.m06.d29;

/**
 * @author ： cxyxh
 * @date : 2021/6/29 21:56
 * @describetion : leetcode编号101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        boolean res = isSymmetric(root);
        System.out.println(res);

        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        res = isSymmetric(root);
        System.out.println(res);
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 递归
     *
     * 思路：传进来root的左子节点p和右子节点q
     * 如果p和q同时为null，那么它们相等返回true
     * 如果p或者q为null，那么它们不相等返回false
     * 否则判断p和q的值 && 判断p的左子节点和q的右子节点 && 判断p的右子节点和q的右子节点 是否相等
     *
     * 时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)。
     * 空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)。
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }

    }
}
