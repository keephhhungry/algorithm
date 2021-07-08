package zuo.level1.class6;

/**
 * @author ： cxyxh
 * @date : 2021/7/4 11:56
 * @describetion : 树的前中后序遍历
 */
public class Code00_TraversalBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println("前序遍历开始");
        pre(node);//1 2 4 5 3 6 7
        System.out.println("前序遍历结束");

        System.out.println("中序遍历开始");
        in(node);//4 2 5 1 6 3 7
        System.out.println("中序遍历结束");

        System.out.println("后序遍历开始");
        post(node);//4 5 2 6 7 3 1
        System.out.println("后序遍历结束");
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void pre(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value+" ");
        pre(node.left);
        pre(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void in(Node node){
        if(node == null){
            return;
        }
        in(node.left);
        System.out.print(node.value+" ");
        in(node.right);

    }

    /**
     * 后续遍历
     * @param node
     */
    public static void post(Node node){
        if(node == null){
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.value+" ");

    }
}
