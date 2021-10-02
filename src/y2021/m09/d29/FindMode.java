package y2021.m09.d29;

import java.util.*;

/**
 * @author ： cxyxh
 * @date : 10/2/2021 9:46 AM
 * @describetion :501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMode {

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
        TreeNode root = new TreeNode(1);
        root.right = null;
        root.left = new TreeNode(2);
        //root.right.left = new TreeNode(2);
        int[] res = findMode(root);
        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public static int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map = process(root, map);

        Integer max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                list.clear();
                max = value;
                list.add(entry.getKey());
            } else if (value == max) {
                list.add(entry.getKey());
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public static Map<Integer, Integer> process(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return null;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        process(node.left, map);
        process(node.right, map);
        return map;
    }

}
