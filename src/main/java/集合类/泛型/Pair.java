package 集合类.泛型;

public class Pair<U,V> {
    private  U first;
    private V second;

    public Pair(U first,V second){
        this.first = first;
        this.second = second;
    }

    public U getFirst(){
        return this.first;
    }

    public V getSecond(){
        return this.second;
    }

    public <E> int getMax(E[] data){
        return 0;
    }
}

class NumberPair<U extends Number,V extends Number> extends Pair<U,V>{

    public NumberPair(U first, V second) {
        super(first, second);
    }

    public static <T extends Comparable<T>> T max(T[] arr){
        T max = arr[0];
        for (int i = 1;i<arr.length;i++){
            if (max.compareTo(arr[i])<0) {
                max = arr[i];
            }
        }
        return max;
    }
}


