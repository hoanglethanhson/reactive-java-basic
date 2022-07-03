package com.rp.sec09;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02OverlapAndDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(3, 1)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    public static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event " + i);
    }
}
