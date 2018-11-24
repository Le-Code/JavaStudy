package 集合类.泛型;

public class Test {

    @org.junit.Test
    public void test1(){
        NumberPair<Integer,Integer> numberPair = new NumberPair<>(1,2);
        System.out.println(numberPair.getFirst());
    }

    @org.junit.Test
    public void test2(){
        DynamicArray<Number> numberDynamicArray = new DynamicArray<>();
        DynamicArray<Integer> integerDynamicArray = new DynamicArray<>();
        integerDynamicArray.add(1);
        integerDynamicArray.add(2);
        numberDynamicArray.addAll(integerDynamicArray);
        for (int i = 0;i<numberDynamicArray.getSize();i++){
            System.out.println(numberDynamicArray.get(i));
        }
    }

}
