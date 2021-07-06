package y2021.m07.d06;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ： cxyxh
 * @date : 2021/7/6 23:34
 * @describetion :155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    // 定义一个使用的栈，一个辅助栈
    public Deque<Integer> xStack;
    public Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 压栈的时候，使用的栈正常压入；辅助栈将目前栈顶的值与要压入的值做比较，把最小的值压入
     * 如果情况如下
     *  -2   -2
     *  -1   -1
     *   0    0
     * 右边的辅助栈栈顶始终保持最小值
     *
     *   0   -2
     *  -1   -2
     *  -2   -2
     * 右边的辅助栈栈顶也始终保持最小值
     *
     * @param val
     */
    public void push(int val) {
        xStack.push(val);
        xStack.push(Math.min(minStack.peek(), val));
    }

    /**
     * 弹出时两个栈一起弹出
     */
    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    /**
     * 获取最顶上的值的时候，直接peek
     * @return
     */
    public int top() {
        return xStack.peek();
    }

    /**
     * 获取最小值的时候从最小栈中弹出
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }

}
