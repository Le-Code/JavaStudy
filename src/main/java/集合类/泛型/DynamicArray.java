package 集合类.泛型;

import java.util.Arrays;

/**
 * 模拟ArrayList
 * 创建一个动态数组
 */
public class DynamicArray <T>{

    private int defaultSize = 10;

    private Object[] contents;

    private int size;

    public DynamicArray(){
        this.contents = new Object[defaultSize];
    }

    private void ensureCapacity(int mimiSize){
        int oldCapacity = contents.length;
        if (oldCapacity>mimiSize)
            return;
        int newCapacity = oldCapacity*2;
        if (newCapacity<mimiSize)
            newCapacity = mimiSize;
        //Arrays.copyOf()调用的底层是System.arraycopy();
        this.contents = Arrays.copyOf(contents,newCapacity);
    }

    public void add(T data){
        ensureCapacity(size+1);
        contents[size++] = data;
    }

    public T get(int index){
        return (T) contents[index];
    }

    public int getSize(){
        return size;
    }

    public void setElem(int index,T data){
        contents[index] = data;
    }

    /*public <E extends T> void addAll(DynamicArray<E> c){
        for (int i = 0;i<c.size;i++){
            add(c.get(i));
        }
    }*/

    public void addAll(DynamicArray<? extends T> c){
        for (int i = 0;i<c.getSize();i++){
            add(c.get(i));
        }
    }

    public void copyTo(DynamicArray<? super T> c){
        for (int i = 0;i<size;i++){
            c.add(get(i));
        }
    }


}
