package rxjava.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 第一个具体的使用实例
 * 同步
 */
public class Demo1 {

    public static void main(String[] args) {

        //1.创建一个小说
        Observable novel = Observable.create(new ObservableOnSubscribe<String>() {
            //计划表，添加计划
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                //onNext可以连续发送，发送的都能接受
                observableEmitter.onNext("连载1");
                Thread.sleep(1000);
                observableEmitter.onNext("连载2");
                Thread.sleep(1000);
                observableEmitter.onNext("连载3");
                //error和complete只能选择一个
//                observableEmitter.onError(new RuntimeException("runtimeException"));
                observableEmitter.onComplete();
            }
        });

        Observer<String> reader = new Observer<String>() {

            Disposable d = null;

            /**
             * @param disposable 相当于订阅关系，可以取消订阅
             */
            @Override
            public void onSubscribe(Disposable disposable) {
                d = disposable;
                System.out.println("reader subScribe");
            }

            @Override
            public void onNext(String s) {
//                if (s.equals("连载2")){
//                    if (d!=null)
//                        d.dispose();
//                }
                System.out.println("read receive:"+s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("reader receive error");
            }

            @Override
            public void onComplete() {
                System.out.println("reader receive complete");
            }
        };

        novel.subscribe(reader);
    }

}
