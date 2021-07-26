package zuo.level2.class7;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： cxyxh
 * @date : 7/26/2021 7:11 PM
 * @describetion : 查询树的最大宽度
 */
public class Code04_TreeMaxWidth {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    /**
     * 采用hashmap
     *
     * @param head
     * @return
     */
    public static int maxWidthUseMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // key是树节点，value是节点所在的层数
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        // 当前统计的层数
        int curLevel = 1;
        // 当前统计层数的节点个数
        int curLevelNodes = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Integer curNodeLevel = levelMap.get(cur);
            // 子树的高度等于父树高度+1
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            // 如果该节点与目前统计的层数一致，那么当前层的节点数++
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        // 当前层，最右节点
        Node curEnd = head;
        // 下一层，最右节点
        Node nextEnd = null;
        int max = 0;
        // 当前层的节点数
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 往队列里里面添加左右子树节点，添加的同时更新下一级子树的最右节点
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            // 如果遍历到最后节点，统计改成的子树数量，重置统计
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                // 把下一级最后子树的节点，更新到当前数的最右节点
                curEnd = nextEnd;
            }
        }
        return max;
    }


    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
