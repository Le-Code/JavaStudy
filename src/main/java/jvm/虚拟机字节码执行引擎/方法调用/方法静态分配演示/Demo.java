package jvm.虚拟机字节码执行引擎.方法调用.方法静态分配演示;

public class Demo {

    static class Parent{
        public void show(){

        }
    }

    static class child1 extends Parent{
        public void show(){
            System.out.println("child1 show");
        }
    }

    static class child11 extends child1{
        @Override
        public void show() {
            System.out.println("child11 show");
        }
    }

    static class child2 extends Parent{
        public void show(){
            System.out.println("child2 show");
        }
    }

    public static void main(String[] args){
        Parent p = new child1();
        p.show();
    }

}
