package com.rp.sec08;

import com.rp.sec08.helper.AmericanAirlines;
import com.rp.sec08.helper.EmiratesFlights;
import com.rp.sec08.helper.QatarFlights;
import courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                QatarFlights.getFlights(),
                EmiratesFlights.getFlights(),
                AmericanAirlines.getFlights()
        );
        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
