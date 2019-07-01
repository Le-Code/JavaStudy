package 设计模式.建造者模式;

public abstract class PersonBuilder {

    public PersonBuilder(){

    }

    public abstract void drawHead();

    public abstract void drawLeftHand();

    public abstract void drawLeftLeg();

    public abstract void drawRightHand();

    public abstract void drawRightLeg();

}
