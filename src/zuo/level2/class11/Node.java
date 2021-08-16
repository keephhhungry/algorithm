package zuo.level2.class11;

import java.util.ArrayList;

/**
 * @author ： cxyxh
 * @date : 8/7/2021 7:50 PM
 * @describetion : 点结构的描述
 */
public class Node {

    // 点的数值
    public int value;

    // 到这个节点的节点数
    public int in;

    // 从这个节点出去的节点数
    public int out;

    // 从这个节点出去的节点
    public ArrayList<Node> nexts;

    // 从这个节点出去的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, int in, int out, ArrayList<Node> nexts, ArrayList<Edge> edges) {
        this.value = value;
        this.in = in;
        this.out = out;
        this.nexts = nexts;
        this.edges = edges;
    }
}
