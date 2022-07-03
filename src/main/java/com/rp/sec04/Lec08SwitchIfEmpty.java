package com.rp.sec04;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    //take data from cache operation
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    //directly query to database if no cached data
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }
}
