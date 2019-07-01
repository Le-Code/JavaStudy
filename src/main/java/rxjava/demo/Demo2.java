package rxjava.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 使用异步调用，如果不指定那么默认就是哪个线程产生就在哪个线程消费
 * 使用异步，可以选在在后台产生，前台调用
 */
public class Demo2 {

    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("连载1");
                observableEmitter.onNext("连载2");
                observableEmitter.onNext("连载3");
                observableEmitter.onComplete();
            }
        }).observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("subscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });
    }

}
