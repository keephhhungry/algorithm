package zuo.level2.class12;

import zuo.level2.class11.Edge;
import zuo.level2.class11.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ： cxyxh
 * @date : 8/8/2021 1:57 PM
 * @describetion : 最短路径 迪杰斯特拉算法
 */
public class Code01_Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node from) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);
        // 打过对号的点
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            //  原始点  ->  minNode(跳转点)   最小距离distance
            Integer distance = distanceMap.get(minNode);
            // 遍历最小节点的所以可以达到节点
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                // 如果节点没有到达过，那么更新达到边的长度
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                    // 如果节点到达过，那么更新最小的长度
                }else{
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            // 把节点添加到已选择的节点中
            selectedNodes.add(minNode);
            // 继续找最小的节点
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }

        return distanceMap;
    }

    // 获取最小的但是没有使用过的节点
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

}
