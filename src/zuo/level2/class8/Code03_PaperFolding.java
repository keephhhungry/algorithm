package zuo.level2.class8;

/**
 * @author ： cxyxh
 * @date : 8/2/2021 7:16 PM
 * @describetion :纸张对折
 */
public class Code03_PaperFolding {

    public static void printAllFolds(int N) {
        process(1, N, true);
        System.out.println();
    }


    /**
     * 当前你来了一个节点，脑海中想象的
     * 这个节点在第i层，一共有N层，N固定不变的
     * 这个节点如果是凹的话，down = T
     * 这个节点如果是凸的话，down = F
     * 中序打印以你想象的节点为头的整棵树
     *             凹
     *         凹      凸
     *      凹   凸   凹   凸
     *
     * @param i
     * @param N
     * @param down
     */
    public static void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.println(down ? "凹 " : "凸 ");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
    }
}
