package spring.demo2.spring的AOP.AspectJ开发;

public class UserDao {
    public void add(){
        System.out.println("user add");
    }

    public void delete(){
        System.out.println("user delete");
    }

    public int getSum(int a,int b){
        return a+b;
    }
}
