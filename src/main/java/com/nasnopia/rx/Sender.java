package com.nasnopia.rx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;


/**
 * Created by josetesan on 16/01/17.
 */
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private NotifyClass notifyClass;

    public Sender() {
        this.notifyClass = new NotifyClass();
    }

    public Observable<Boolean> send(String value)  {

        return Observable.fromCallable(() -> notifyClass.handleValue(value));

    }



}
