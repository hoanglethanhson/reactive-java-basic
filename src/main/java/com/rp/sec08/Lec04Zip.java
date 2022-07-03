package com.rp.sec08;

import courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getTires())
                //.doOnNext(Tuple3::getT3)
                .subscribe(Util.subscriber());
    }

    public static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "body");
    }

    public static Flux<String> getEngine() {
        return Flux.range(1, 3)
                .map(i -> "engine");
    }

    public static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(i -> "tires");
    }
}
