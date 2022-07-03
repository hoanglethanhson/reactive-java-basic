package com.rp.sec02;

import courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(Util.onNext());

        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array)
                .subscribe(Util.onNext());
    }

}
