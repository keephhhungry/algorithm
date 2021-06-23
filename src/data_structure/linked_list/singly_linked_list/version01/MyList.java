package data_structure.linked_list.singly_linked_list.version01;

/**
 * @author ： cxyxh
 * @date : 2021/5/10 23:21
 * @describetion :
 */
public interface MyList {

    /**
     * 根据角标添加数据
     * @param index
     * @param node
     * @throws Exception
     */
    public void insert(int index,ListNode<?> node) throws Exception;


    /**
     * 根据角标删除数据
     * @param index 角标
     * @throws Exception
     */
    public void delete(int index) throws Exception;

    /**
     * 根据角标修改链表对应位置的数据
     * @param index 角标
     * @param data 数据
     * @param <T>
     * @throws Exception
     */
    public <T> void update(int index,T data) throws Exception;

    /**
     * 查询
     * @param data
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> ListNode<T> find(T data) throws Exception;

    /**
     * 获取链表长度
     * @return
     * @throws Exception
     */
    public int size() throws Exception;
}
