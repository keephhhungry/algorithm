package zuo.level2.class11;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ： cxyxh
 * @date : 8/7/2021 7:51 PM
 * @describetion :
 */
public class Graph {

    // 节点
    public HashMap<Integer, Node> nodes;

    // 边
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
