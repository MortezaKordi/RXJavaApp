package com.example.mory.rxjavaapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;
    @BindView(R.id.myRecyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;
    private final String TAG = "RxJava";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        linearLayoutManager = new LinearLayoutManager(this);
//        rvCustomAdapter = new RVCustomAdapter();
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(rvCustomAdapter);
////
        Observable.just("How are you?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                txtHi.setText(s);
            }
        });
//
//        // TextView Text the Lambda Way
//        Observable.just("Hey! What's Up").subscribe(txtHi::setText);
//
////        Observable.just("Morteza", "Monica", "Joey", "Ross", "Jack", "John").subscribe(new Consumer<String>() {
////            @Override
////            public void accept(String s) throws Exception {
////                rvCustomAdapter.addStringToList(s);
////            }
////        });
//
//        Entry entry1 = new Entry("PS4", BigDecimal.valueOf(1500), new Date());
//        Entry entry2 = new Entry("Xbox One", BigDecimal.valueOf(2000), new Date());
//        Entry entry3 = new Entry("Xbox One s", BigDecimal.valueOf(2500), new Date());
//        Entry entry4 = new Entry("XBox One X", BigDecimal.valueOf(3000), new Date());
//
////        Observable.just(entry1, entry2, entry3, entry4).subscribe(new Consumer<Entry>() {
////            @Override
////            public void accept(Entry entry) throws Exception {
////
////                rvCustomAdapter.addEntry(entry);
////            }
////        });
//
//        Observable.just(entry1, entry2, entry3, entry4).subscribe(s->rvCustomAdapter.addEntry(s));
//
//
//        Observable.just("Hi There").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
//            }
//        });
//
//       Disposable myDisposable = Observable.just("Thank you!").subscribe();
//       myDisposable.dispose();
//       if (myDisposable.isDisposed()) {
//
//       } else {
//
//       }
//
//       Disposable groupDisposables = new CompositeDisposable(
//
//               Observable.just("hi").subscribe(),
//               Observable.just("How").subscribe(),
//               Observable.just("Are").subscribe(),
//               Observable.just("You").subscribe()
//
//       );
//
//       groupDisposables.dispose();


//        Observable.just("Joey is a boxer", "Monica is a KickBoxer", "Ross is a wrestler").subscribeOn(Schedulers.io()).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i(TAG, "The accept method is executed on this thread: " + Thread.currentThread().getName() + " " + s);
//            }
//        });

//        Observable.just("Joey is a boxer", "Monica is a KickBoxer", "Ross is a wrestler").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i(TAG, "The accept method is executed on this thread: " + Thread.currentThread().getName() + " " + s);
//            }
//        });

      //  .subscribeOn(Schedulers.io()) // Using Scheduler

//        Observable.just("Joey is a Boxer", "Monica is a KickBoxer")
//                .doOnNext(value -> showCurrentThreadNameOnTheLogWithStateAndValue("DoOnNext", value))
//                .subscribe(sValue -> showCurrentThreadNameOnTheLogWithStateAndValue("Subscribe", sValue));

//        Observable.just("Joey is a Boxer", "Monica is a KickBoxer")
//                .subscribeOn(Schedulers.io())
//                .doOnNext(value -> showCurrentThreadNameOnTheLogWithStateAndValue("DoOnNext", value))
//                .subscribe(sValue -> showCurrentThreadNameOnTheLogWithStateAndValue("Subscribe", sValue));

//        Observable.just("Download an Image from Internet")
//                .subscribeOn(Schedulers.io())
//                .doOnNext(value -> showCurrentThreadNameOnTheLogWithStateAndValue("DoOnNext", value))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(sValue -> showCurrentThreadNameOnTheLogWithStateAndValue("Subscribe", sValue));


//        Observable.just("Joey is a programmer", "Monica is a designer")
//                .subscribeOn(Schedulers.io())
//                .doOnNext(i -> showCurrentThreadNameOnTheLogWithStateAndValue("doOnNext", i))
//                .doOnEach(i -> showCurrentThreadNameOnTheLogWithState("doOnEach"))
//                .doOnComplete(() -> showCurrentThreadNameOnTheLogWithState("onComplete"))
//                .doOnTerminate(() -> showCurrentThreadNameOnTheLogWithState("doOnTerminate"))
//                .doFinally(() -> showCurrentThreadNameOnTheLogWithState("doFinally"))
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(i -> showCurrentThreadNameOnTheLogWithState("doOnSubscribe"))
//                .subscribe(i -> showCurrentThreadNameOnTheLogWithStateAndValue("subscribe", i));


        PublishSubject<Integer> myObservable = PublishSubject.create();
        // Bad Strategy = No Strategy
//           myObservable.observeOn(Schedulers.computation())
//                  .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscribe", item + ""));
//
//        for (int i = 0; i < 2000000; i++) {
//
//            myObservable.onNext(i);
//        }

        // Missing Exception Strategy
//        myObservable.toFlowable(BackpressureStrategy.MISSING)
//                .observeOn(Schedulers.computation())
//                .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscriber", item + ""));

        // Dropping Strategy
//        myObservable.toFlowable(BackpressureStrategy.DROP)
//                .observeOn(Schedulers.computation())
//                .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscriber", item + ""));

        // Sample Strategy
//        myObservable.toFlowable(BackpressureStrategy.MISSING)
//                .sample(10, TimeUnit.MILLISECONDS)
//                .observeOn(Schedulers.computation())
//                .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscriber", item + ""));

        // Latest Strategy
//        myObservable.toFlowable(BackpressureStrategy.LATEST)
//                .observeOn(Schedulers.computation())
//                .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscriber", item + ""));

        // Debounce Strategy

//        myObservable.toFlowable(BackpressureStrategy.LATEST)
//                .observeOn(Schedulers.computation())
//                .debounce(10, TimeUnit.MILLISECONDS)
//                .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscriber", item + ""));

        // Buffer Strategy
//        myObservable.toFlowable(BackpressureStrategy.BUFFER)
//                .observeOn(Schedulers.computation())
//                .subscribe(item -> showCurrentThreadNameOnTheLogWithStateAndValue("subscriber", item + ""));
//
//        for (int i = 0; i < 2000000; i++) {
//
//            myObservable.onNext(i);
//        }

//        Completable myCompletable = Completable.fromAction(() -> {
//
//            Log.i(TAG, "Joey wants to become a boxer in 3 months");
//
//            showCurrentThreadNameOnTheLogWithState("fromAction");
//        });
//
//
//        myCompletable.subscribe(() -> {
//
//            Log.i(TAG, "3 months passed - Joey is now a boxer");
//
//            showCurrentThreadNameOnTheLogWithState("subscribe");
//
//        }, throwable -> {
//            Log.i(TAG, throwable.toString());
//        });

//        Single mySingle = Single.just("King of Jungle");
//        mySingle.subscribe(kingOfJungle -> {
//
//            Log.i(TAG, "I now declare Lion as the " + kingOfJungle);
//        }, throwable -> {
//            Log.i(TAG, throwable.toString());
//        });

        Maybe.just("Ross wants to become an iOS Developer in 3 months").subscribe(

                success -> Log.i(TAG, "Ready! - Let's do it"),
                throwable -> Log.i(TAG, "Ross failed to become an iOS Developer"),
                () -> Log.i(TAG, "Finished - Congrats to Ross")

        );


    }

    private void showCurrentThreadNameOnTheLogWithStateAndValue(String state, String value) {

        String des = Thread.currentThread().getName() + " Thread" + " - " + " State: " + state + " - " + " Value: " + value;
        Log.i(TAG, des);

    }

    private void showCurrentThreadNameOnTheLogWithState(String state) {

        String des = Thread.currentThread().getName() + " Thread" + " - " + " State: " + state;
        Log.i(TAG, des);

    }






}
