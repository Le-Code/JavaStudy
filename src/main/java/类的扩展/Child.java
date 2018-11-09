package 类的扩展;

public class Child implements Interface1 {
    public static void main(String[] args){
        Child test1 = new Child();
        test1.hi();
        Interface1 interface1 = new Interface1() {
            @Override
            public void hi() {
                System.out.println("hello");
            }
        };
        interface1.hi();
    }

    @Override
    public void hi() {
        System.out.println("子类重写hi");
    }
}
