package com.nasnopia.rx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by josetesan on 16/01/17.
 */
public class NotifyClass {


    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyClass.class);


    public Boolean handleValue(String value) {
        try {
            LOGGER.info("Sending {}", value);
            TimeUnit.SECONDS.sleep(1);
            LOGGER.info("Sent  {}", value);
        } catch (InterruptedException e) {
            LOGGER.error("Error ",e);
        }
        return true;
    }
}
