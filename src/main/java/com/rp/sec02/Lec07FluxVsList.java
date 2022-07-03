package com.rp.sec02;

import com.rp.sec02.helper.NameGenerator;
import courseutil.Util;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        //List<String> names = NameGenerator.getNames(5);
        NameGenerator.getNames(5)
                        .subscribe(Util.onNext());
        //System.out.println(names);
    }
}
