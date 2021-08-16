package zuo.level2.class11;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author ： cxyxh
 * @date : 8/7/2021 9:19 PM
 * @describetion :图的深度优先遍历
 */
public class Code02_DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                // 只要有一个邻居没有打印过
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }

    }

}
