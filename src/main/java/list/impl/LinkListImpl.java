package list.impl;

import org.jetbrains.annotations.NotNull;

public class LinkListImpl<Item> implements list.LinkList<Item> {

    private Node head = null;
    private int length = 0;

    @Override
    public void addLast(@NotNull Item item) {
        length++;
        if (isEmpty()) {
            head = new Node(item);
            return;
        }

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = new Node(item);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    @Deprecated
    public boolean isFull() {
        return false; // 永远是false
    }

    @Override
    public int getIndex(@NotNull Item item) {
        int index = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.value == item) return index;
            index++;
        }
        return -1;
    }

    @Override
    public Item get(int index) {
        if (index > length) throw new RuntimeException("索引越界");

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    @Override
    public void insert(int index, @NotNull Item item) {
        if (index > length) throw new RuntimeException("索引越界");

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node next = temp.next;
        temp.next = new Node(item, next);
    }

    @Override
    public void remove(int index) {
        if (index > length) throw new RuntimeException("索引越界");

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        length--;
    }

    @Override
    public void delList() {
        // 交给万能的Garbage Collection吧！
        System.out.println("交给万能的Garbage Collection吧！");
    }

    private class Node {
        private final Item value;
        private Node next;

        public Node(Item item) {
            this.value = item;
        }

        public Node(Item value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("LinkList: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            builder.append(temp).append("->");
        }

        return builder.append("null").toString();
    }
}
