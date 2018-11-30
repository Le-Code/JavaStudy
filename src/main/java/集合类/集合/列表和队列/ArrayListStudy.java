package 集合类.集合.列表和队列;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

/**
 * 学习
 */
public class ArrayListStudy {
    /**
     * 测试迭代器
     */
    @Test
    public void test(){
        List<Integer> integerList = Arrays.asList(1,2,3,43,5);
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    /**
     * 测试ListIterator迭代器，扩展了Iterator
     * boolean hasNext();
     * boolean hasPrevious()
     * E previous()
     * int nextIndex()
     * int previousIndex()
     * void set(E e)
     * void add(E e)
     */
    @Test
    public void test2(){
        List<Integer> integerList = Arrays.asList(1,2,3,43,5);
        ListIterator<Integer> integerListIterator = integerList.listIterator(integerList.size());
        while (integerListIterator.hasPrevious())
            System.out.println(integerListIterator.previous());
    }

    /**
     * 使用迭代器自身删除元素
     */
    @Test
    public void test3(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.addAll(Arrays.asList(1,2,3,4,54,3));
        integerList.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer==54)
                    return true;
                return false;
            }
        });
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            /*if (iterator.next() > 10) {
                iterator.remove();
            }*/
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        int t = 9&8;
        System.out.println(t);
    }

}
