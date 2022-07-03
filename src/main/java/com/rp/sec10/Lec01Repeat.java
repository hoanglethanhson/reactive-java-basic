package com.rp.sec10;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec01Repeat {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .repeat(() -> atomicInteger.get() < 14)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed"))
                .doOnComplete(() -> System.out.println("--completed"))
                .map(i -> atomicInteger.getAndIncrement());
    }
}
