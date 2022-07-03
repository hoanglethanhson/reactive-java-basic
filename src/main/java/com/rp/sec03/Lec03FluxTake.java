package com.rp.sec03;

import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .take(3)
                .subscribe(Util.subscriber());
    }
}
