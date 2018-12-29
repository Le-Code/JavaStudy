package 类的扩展;

public class EnumTest {
    public static void main(String[]args){
        EnumSize size = EnumSize.LARGE;
        System.out.println(size.getLabel());
        System.out.println(size.ordinal());
        EnumSize size1 = EnumSize.fromLabel("s");
        System.out.println(size1);
    }

}
