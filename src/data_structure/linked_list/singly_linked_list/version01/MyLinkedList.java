package data_structure.linked_list.singly_linked_list.version01;

/**
 * @author ： cxyxh
 * @date : 2021/5/10 23:33
 * @describetion :
 */
public class MyLinkedList implements MyList {

    //头结点
    private ListNode<?> head = new ListNode<Object>(Integer.MIN_VALUE, null);

    //增
    @Override
    public void insert(int index, ListNode<?> node) throws Exception {
        //可以先判断索引的大小跟链表大小
        //如果只有头结点,直接添加即可
        if (head.next == null) {
            head.next = node;
            return;
        }
        //如果不止,就添加到对应的索引
        //找到要插入的结点的前一个结点
        ListNode<?> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            //如果到了最后一个结点，直接添加到最后一个 ,解决索引过大问题
            if (temp.next == null) {
                temp.next = node;
                return;
            }
        }
        //插入
        ListNode<?> tempNext = temp.next;
        temp.next = node;
        node.next = tempNext;
    }

    //删
    @Override
    public void delete(int index) throws Exception {
        ListNode<?> tempLast = head;//要删除的结点的上一结点
        ListNode<?> temp = head.next;//第一个结点
        for (int i = 0; i < index; i++) {
            tempLast = temp;
            temp = temp.next;
        }
        //将删除结点的上下结点相连
        ListNode<?> tempNext = temp.next;
        tempLast.next = tempNext;
    }

    //改
    @Override
    public <T> void update(int index, T data) throws Exception {
        ListNode temp = head.next;//第一个结点
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
    }

    //查
    @Override
    public <T> ListNode<T> find(T data) throws Exception {
        ListNode temp = head.next;
        for (; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return temp;
            }
        }
        return null;
    }

    //获得长度
    @Override
    public int size() throws Exception {
        int size = 0;
        ListNode temp = head.next;
        for (; temp != null; temp = temp.next) {
            size++;
        }
        return size;
    }

    //输出所有结点
    public static void print(MyLinkedList list) {
        ListNode temp = list.head;
        for (; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println("--------------------------------");
    }

}
