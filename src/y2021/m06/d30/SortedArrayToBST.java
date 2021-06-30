package y2021.m06.d30;

/**
 * @author ： cxyxh
 * @date : 2021/6/30 22:12
 * @describetion :leetcode编号108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 按 严格递增 顺序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }


    /**
     * 中序遍历，总是选择中间位置左边的数字作为根节点
     *
     * 思路：选择中间位置左边的数字作为根节点，则根节点的下标为mid=(left+right)/2，此处的除法为整数除法
     *      该节点的左子节点和右子节点递归调用方法，生成对应的节点和其左子节点，右子节点
     *
     * 时间复杂度：O(n)，其中 n 是数组的长度。每个数字只访问一次。
     * 空间复杂度：O(logn)，其中 n 是数组的长度。空间复杂度不考虑返回值，因此空间复杂度主要取决于递归栈的深度，递归栈的深度是O(logn)。
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
