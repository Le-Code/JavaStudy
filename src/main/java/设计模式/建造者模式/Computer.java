package 设计模式.建造者模式;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<String> itemList = new ArrayList<>();

    public void addItem(String part){
        itemList.add(part);
    }

    public void show(){
        for (String part:itemList){
            System.out.println(part+" == 组装好了");
        }
        System.out.println("电脑组装成功");
    }
}
