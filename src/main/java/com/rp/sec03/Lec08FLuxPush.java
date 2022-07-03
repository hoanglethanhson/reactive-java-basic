package com.rp.sec03;

import com.rp.sec03.helper.NameProducer;
import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08FLuxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());
        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(2);
    }
}
