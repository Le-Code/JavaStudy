package 集合类.集合.Map和Set;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.*;

public class EnumSetStudy {

    @Test
    public void test1(){
        Set<DAY> weekend = EnumSet.noneOf(DAY.class);
        weekend.add(DAY.SATURDAY);
        weekend.add(DAY.SUNDAY);
        System.out.println(weekend);
    }

    @Test
    public void test2(){
        Worder[] worders = new Worder[]{
                new Worder("张三",EnumSet.of(DAY.MONDAY,DAY.TUESDAY,DAY.WEDNESDAY,DAY.FRIDAY)),
                new Worder("李四",EnumSet.of(DAY.TUESDAY,DAY.THURSDAY,DAY.FRIDAY)),
                new Worder("王五",EnumSet.of(DAY.TUESDAY,DAY.THURSDAY))
        };
        //哪些天一个人都不会来，求时间的补集
        Set<DAY> days = EnumSet.allOf(DAY.class);
        for (Worder worder:worders){
            days.removeAll(worder.getAvailableDays());
        }
        System.out.println(days);
        //哪些天至少有一个人来，求时间的交集
        days = EnumSet.noneOf(DAY.class);
        for (Worder worder:worders){
            days.addAll(worder.getAvailableDays());
        }
        System.out.println(days);
        //哪些天所有人都会来,求时间的交集
        days = EnumSet.allOf(DAY.class);
        for (Worder worder:worders){
            days.retainAll(worder.getAvailableDays());
        }
        System.out.println(days);
        //哪些人周一周二来
        Set<Worder> availableWorkers = new HashSet<>();
        for (Worder worder:worders){
            if (worder.getAvailableDays().containsAll(EnumSet.of(DAY.MONDAY,DAY.TUESDAY)))
                availableWorkers.add(worder);
        }
        System.out.println(Arrays.toString(availableWorkers.toArray()));
        //哪些天至少有两个人来
        Map<DAY,Integer> countMap = new EnumMap<DAY, Integer>(DAY.class);
        for (Worder worder:worders){
            for (DAY day:worder.getAvailableDays()){
                countMap.put(day,countMap.getOrDefault(day,0)+1);
            }
        }
        for (Map.Entry<DAY,Integer> entry:countMap.entrySet()){
            if (entry.getValue()>=2){
                System.out.print(entry.getKey()+" ");
            }
        }
    }

    @Test
    public void test3(){
        long elements = 23;
        System.out.println(Long.bitCount(elements));
    }

    enum DAY{
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }

    class Worder{
        String name;
        Set<DAY> availableDays;
        public Worder(String name,Set<DAY> availableDays){
            this.name = name;
            this.availableDays = availableDays;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<DAY> getAvailableDays() {
            return availableDays;
        }

        public void setAvailableDays(Set<DAY> availableDays) {
            this.availableDays = availableDays;
        }

        @Override
        public String toString() {
            return "Worder{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
