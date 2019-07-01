package 设计模式.建造者模式;

public class PersonDirector {

    private PersonBuilder personBuilder;

    public PersonDirector(PersonBuilder personBuilder){
        this.personBuilder = personBuilder;
    }

    public void create(){
        personBuilder.drawHead();
        personBuilder.drawLeftHand();
        personBuilder.drawLeftLeg();
        personBuilder.drawRightHand();
        personBuilder.drawRightLeg();
    }
}
