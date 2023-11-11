package list;

import org.jetbrains.annotations.NotNull;


public interface SqList<Item> {

    // 采用尾插法依次插入元素 a, b, c, d, e
    void addLast(@NotNull Item item);

    // 输出顺序表L
    String toString();

    // 输出顺序表 L 长度
    int size();

    // 判断顺序表 L 是否为空
    boolean isEmpty();

    // 判断顺序表是否满了
    boolean isFull();

    // 输出元素a 的位置;
    int getIndex(@NotNull Item item);

    // 输出顺序表 L 的第 3 个元素;
    Item get(int index);

    // 在第 4 个元素位置上插入元素 f;
    void insert(int index, @NotNull Item item);

    // 删除 L 的第 3 个元素;
    void remove(int index);

    // 释放顺序表 L;
    void delList();
}
