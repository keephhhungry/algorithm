package y2021.m06.d27;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 2021/6/27 12:45
 * @describetion : leetcode编号94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal {

    // TODO 迭代法不会
    public static void main(String[] args) {
        /**
         * 树节点如下
         *       1
         *     /  \
         *  null   2
         *       /   \
         *      3    null
         * root = [1,null,2,3]
         */
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        inorderTraversal(root);
    }

    /**
     * 递归法
     * <p>
     * 思路：中序遍历，先遍历左子节点，再遍历根节点，最后遍历右子节点
     * <p>
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     * 空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}
