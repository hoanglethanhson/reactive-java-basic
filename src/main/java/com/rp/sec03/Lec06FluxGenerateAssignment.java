package com.rp.sec03;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
                    String country;
                    country = Util.faker().country().name();
                    synchronousSink.next(country);
                    atomicInteger.incrementAndGet();
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
