package 实验;

import java.util.HashMap;
import java.util.Map;

public class CustomMap<K,V> extends HashMap<K,V> {

    @Override
    public String toString() {
        for (Map.Entry<K,V>entry:entrySet()){
            return entry.getKey()+"@"+entry.getValue();
        }
        return "";
    }
}
