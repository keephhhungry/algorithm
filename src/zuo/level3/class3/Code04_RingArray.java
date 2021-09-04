package zuo.level3.class3;

/**
 * @author ： cxyxh
 * @date : 8/31/2021 10:38 PM
 * @describetion :用循环数组实现队列
 */
public class Code04_RingArray {

    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        // 插入
        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        // 弹出
        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 下一个角标，如果是N，那么回到0，否则+1;
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }


    }
}
