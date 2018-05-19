package spring.demo1;

public class HelloWorldService {

    private HelloWord helloWord;

    public void setHelloWord(HelloWord helloWord){
        this.helloWord = helloWord;
    }

    public HelloWord getHelloWord(){
        return this.helloWord;
    }
}
