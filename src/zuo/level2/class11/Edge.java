package zuo.level2.class11;

/**
 * @author ： cxyxh
 * @date : 8/7/2021 7:50 PM
 * @describetion :边的描述
 */
public class Edge {

    // 边的权重
    public int weight;

    // 边的出发节点
    public Node from;

    // 边的末尾节点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
