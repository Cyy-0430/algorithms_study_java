package list;

import list.impl.LinkListImpl;
import list.impl.SqListImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LinkListTest {
    private static LinkList<Character> linkList;

    @BeforeAll
    public static void init() {
        linkList = new LinkListImpl<>();
        linkList.addLast('a');
        linkList.addLast('b');
        linkList.addLast('c');
        linkList.addLast('d');
        linkList.addLast('e');
    }

    @Test
    public void test03() {
        System.out.println("SqListTest.test03");
        System.out.println("\t输出顺序表L: " + linkList);
    }

    @Test
    public void test04() {
        System.out.println("SqListTest.test04");
        System.out.println("\t输出顺序表L的长度: " + linkList.size());
    }

    @Test
    public void test05() {
        System.out.println("SqListTest.test05");
        System.out.println("\t判断顺序表L是否为空: " + linkList.isEmpty());
    }

    @Test
    public void test06() {
        System.out.println("SqListTest.test06");
        System.out.println("\t输出顺序表的第三个元素: " + linkList.get(3));
    }

    @Test
    public void test07() {
        System.out.println("SqListTest.test07");
        System.out.println("\t输出元素a的位置: " + linkList.getIndex('a'));
    }

    @Test
    public void test08() {
        System.out.println("SqListTest.test08");
        System.out.println("\t在第 4 个元素位置上插入元素 f");
        linkList.insert(4, 'f');
    }

    @Test
    public void test09() {
        System.out.println("SqListTest.test09");
        System.out.println("\t输出顺序表L: " + linkList);
    }

    @Test
    public void test10() {
        System.out.println("SqListTest.test10");
        System.out.println("\t删除顺序表L第三个元素");
        linkList.remove(3);
    }

    @Test
    public void test11() {
        System.out.println("SqListTest.test11");
        System.out.println("\t输出顺序表L: " + linkList);
    }

    @Test
    public void test12() {
        System.out.println("SqListTest.test12");
        System.out.println("\t释放顺序表");
        System.out.print("\t");
        linkList.delList();
    }
}
