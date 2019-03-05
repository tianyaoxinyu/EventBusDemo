package kotlindemo.forwor.com.eventbusdemo;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Myy on 2019/3/1 16:07
 */
public class RxJavaTest {
    @Test
    public void txRxJava1() {
        main();
    }

    @Test
    public void txRxJava2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("TName:" + Thread.currentThread().getName());
                emitter.onNext(1);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("hh:" + integer);
                    }
                })
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("TName1:" + Thread.currentThread().getName());
                        System.out.println("accept：" + integer);
                    }
                });
    }

    private void main() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

 /*   @Test
    public void testRxJava3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            }
        }).map()
    }*/
}
