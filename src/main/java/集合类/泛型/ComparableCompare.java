package 集合类.泛型;

public class ComparableCompare{

    public <T extends Comparable<T>> T getMax(DynamicArray<T> c){
        T max = c.get(0);
        for (int i = 1;i<c.getSize();i++){
            if (c.get(i).compareTo(max)>0)
                max = c.get(i);
        }
        return max;
    }

    public <T extends Comparable<? super T>> T getMax2(DynamicArray<T> c){
        T max = c.get(0);
        for (int i = 1;i<c.getSize();i++){
            if (c.get(i).compareTo(max)>0)
                max = c.get(i);
        }
        return max;
    }

    public static void main(String[] args){
        ComparableCompare comparableCompare = new ComparableCompare();
        DynamicArray<Child> childDynamicArray = new DynamicArray<>();
        childDynamicArray.add(new Child(20));
        childDynamicArray.add(new Child(10));
//        Child maxChild = comparableCompare.getMax(childDynamicArray);
        Child maxChild = comparableCompare.getMax2(childDynamicArray);
    }
}

class Base implements Comparable<Base> {

    private int sort;

    public Base(int sort){
        this.sort = sort;
    }

    public int getSort(){
        return this.sort;
    }

    @Override
    public int compareTo(Base o) {
        if (sort<o.getSort())
            return -1;
        if (sort>o.getSort())
            return 1;
        return 0;
    }
}

class Child extends Base{

    public Child(int sort) {
        super(sort);
    }

}
