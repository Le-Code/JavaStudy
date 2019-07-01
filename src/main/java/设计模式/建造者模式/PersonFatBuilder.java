package 设计模式.建造者模式;

public class PersonFatBuilder extends PersonBuilder {

    private final String root = "绘制一个胖子的";

    @Override
    public void drawHead() {
        System.out.println(root+"头");
    }

    @Override
    public void drawLeftHand() {
        System.out.println(root+"左右");
    }

    @Override
    public void drawLeftLeg() {
        System.out.println(root+"左脚");
    }

    @Override
    public void drawRightHand() {
        System.out.println(root+"右手");
    }

    @Override
    public void drawRightLeg() {
        System.out.println(root+"右脚");
    }
}
