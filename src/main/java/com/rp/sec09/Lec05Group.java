package com.rp.sec09;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Group {
    public static void main(String[] args) {
        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2) //key
                .subscribe(groupedFlux -> process(groupedFlux, groupedFlux.key()));

        Util.sleepSeconds(60);

    }

    private static void process(Flux<Integer> flux, int key) {
        System.out.println("called");
        flux.subscribe(i -> System.out.println("key: " + key + ", item: " + i));
    }
}
