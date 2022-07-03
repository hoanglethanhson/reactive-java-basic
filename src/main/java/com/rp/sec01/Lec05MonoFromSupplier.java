package com.rp.sec01;

import courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        //use just only when you have data already
        //Mono<String> mono = Mono.just(getName());

        //from supplier
        Supplier<String> stringSupplier = Lec05MonoFromSupplier::getName;
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(Util.onNext());

        Callable<String> stringCallable = Lec05MonoFromSupplier::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext());
    }

    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
