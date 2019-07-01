package 动态代理.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

public class Main2 {

    static class SampledClass{
        public String test(){
            return "hello world";
        }
    }


    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampledClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "hello cglib";
            }
        });

        SampledClass sample = (SampledClass) enhancer.create();
        System.out.println(sample.test());
        System.out.println(sample.toString());
        System.out.println(sample.getClass());
        System.out.println(sample.hashCode());
    }

}
