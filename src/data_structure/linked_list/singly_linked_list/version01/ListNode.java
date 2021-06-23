package data_structure.linked_list.singly_linked_list.version01;

/**
 * @author ： cxyxh
 * @date : 2021/5/10 23:29
 * @describetion :
 */
public class ListNode<T> {

    //为了方便操作，使用public
    public T data;

    public ListNode<?> next = null;

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [data=" + data + ", next=" + next + "]";
    }

}
