package data_structure.linked_list.singly_linked_list.version01;

/**
 * @author ： cxyxh
 * @date : 2021/5/10 23:39
 * @describetion :
 */
public class Test {
    //测试
    public static void main(String[] args) throws Exception {
        MyLinkedList list = new MyLinkedList();
        System.out.println("测试插入");
        list.insert(0, new ListNode<Integer>(1, null));
        list.insert(1, new ListNode<Integer>(2, null));
        list.insert(0, new ListNode<Integer>(3, null));
        list.insert(5, new ListNode<Integer>(4, null));//索引过大问题已解决
        list.insert(4, new ListNode<Integer>(5, null));
        MyLinkedList.print(list);
        System.out.println("测试删除");
        list.delete(3);
        MyLinkedList.print(list);
        System.out.println("测试修改");
        list.update(1, 6);
        MyLinkedList.print(list);
        System.out.println("测试查找");
        ListNode<Integer> node = list.find(6);
        System.out.println(node);
        System.out.println("---------------------------------------");
        System.out.println("测试size");
        System.out.println(list.size());
        System.out.println("---------------------------------------");
    }
}
