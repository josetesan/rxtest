package com.nasnopia.rx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * Created by josetesan on 16/01/17.
 */
public class Rx {

    private static final Logger LOGGER = LoggerFactory.getLogger(Rx.class);


    private static final Integer SIZE = 20;

    private List<String> values;
    private Sender sender;
    private Scheduler scheduler;

    public Rx() {
        values = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            values.add(String.valueOf(i));
        }
        sender = new Sender();
        scheduler = Schedulers.from(Executors.newFixedThreadPool(4));
    }

    public static void main(String[] args) {
        Rx rx = new Rx();
        rx.run();
    }

    public void run() {
        Observable<Boolean> observable =
                Observable
                        .from(values)
                        .flatMap(value -> sender
                                .send(value)
                                .subscribeOn(scheduler));

        observable
                .subscribe(
                        s -> LOGGER.info("Sent value {}", s),
                        e -> LOGGER.error("Error ", e),
                        () -> LOGGER.info("Completed")
                );
    }

}


