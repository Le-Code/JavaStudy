package 集合类.集合.Map和Set;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapStudy {
    /**
     * 测试插入顺序
     */
    @Test
    public void test1(){
        //默认是按照插入顺序
        LinkedHashMap<String,Integer> integerLinkedHashMap = new LinkedHashMap<>();
        integerLinkedHashMap.put("a",1);
        integerLinkedHashMap.put("b",2);
        integerLinkedHashMap.put("c",3);
        integerLinkedHashMap.put("a",4);
        for (Map.Entry<String,Integer> entry:integerLinkedHashMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 按照访问顺序
     */
    @Test
    public void test2(){
        LRUCache<String,Integer>lruCache = new LRUCache<>(2);
        lruCache.put("a",1);
        lruCache.put("b",2);
        lruCache.get("a");
        lruCache.put("v",3);
        for (Map.Entry<String,Integer> entry:lruCache.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 重写一个雷 LRUCache 继承 LinkedHashMap，重写removeEldestEntry方法，实现最近最少使用算法
     * LinkedHashMap 在添加元素的时候会调用该方法，但是本省一直不会返回false(不会被删除)
     * @param <K>
     * @param <V>
     */
    class LRUCache<K,V> extends LinkedHashMap<K,V>{

        private int maxEntries;
        public LRUCache(int maxEntries){
            super(16,0.75f,true);
            this.maxEntries = maxEntries;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size()>maxEntries;
        }
    }
}
