package 集合类.集合.Map和Set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EnumMapStudy {
    /**
     * 简单的实现
     */
    @Test
    public void test1(){
        List<Clothe> clothes = new ArrayList<>();
        Map<Size,Integer> map = new EnumMap<>(Size.class);
        for (Clothe clothe:clothes){
            Size size = clothe.getSize();
            Integer count = map.get(size);
            if (count!=null)
                map.put(size,count+1);
            else
                map.put(size,1);
        }
    }

    enum Size{
        SMALL,MIDDLE,LARGER
    }

    class Clothe{
        String id;
        Size size;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Size getSize() {
            return size;
        }

        public void setSize(Size size) {
            this.size = size;
        }
    }
}
