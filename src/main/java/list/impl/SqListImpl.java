package list.impl;

import list.SqList;
import org.jetbrains.annotations.NotNull;


public class SqListImpl<Item> implements SqList<Item> {
    private final int maxSize;

    private int length;

    private final Item[] items;

    public SqListImpl(int maxSize) {
        this.maxSize = maxSize;
        items = (Item[]) new Object[maxSize];
    }

    public SqListImpl() {
        this(10);
    }

    @Override
    public void addLast(@NotNull Item item) {
        fullInterceptor();

        items[length++] = item;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return length == maxSize;
    }

    @Override
    public int getIndex(@NotNull Item item) {
        for (int i = 0; i < length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Item get(int index) {
        judgeIndex(index);

        return items[index];
    }

    @Override
    public void insert(int index, @NotNull Item item) {
        fullInterceptor();

        if (index > length) {
            items[length++] = item;
            return;
        }

        for (int i = length; i > index; i--) {
            items[i] = items[i - 1];
        }

        length++;
        items[index] = item;
    }

    @Override
    public void remove(int index) {
        judgeIndex(index);

        for (int i = index; i < length; i++) {
            items[i] = items[i + 1];
        }
        items[--length] = null;
    }

    @Override
    public void delList() {
        // 交给万能的Garbage Collection吧！
        System.out.println("交给万能的Garbage Collection吧！");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(items[i]).append(' ');
        }
        return builder.toString();
    }

    // 如果顺序表满了则拦截抛出异常
    private void fullInterceptor() {
        if (isFull()) throw new RuntimeException("顺序表已满，无法加入新的元素");
    }

    // 如果索引超出顺序表长度则拦截抛出异常
    private void judgeIndex(int index) {
        if (index > length) throw new RuntimeException("索引超出顺序表长度");
    }
}
