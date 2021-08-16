package zuo.level2.class11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： cxyxh
 * @date : 8/7/2021 8:06 PM
 * @describetion : 宽度优先遍历
 */
public class Code01_BFS {

    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }


}
