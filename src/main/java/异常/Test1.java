package 异常;

public class Test1 {
    public static void main(String[] args){
        System.out.println();
    }

    public static int test(){
        int ret = 0;
        try{
            return ret;
        }finally {
            ret+=2;
        }
    }
}
