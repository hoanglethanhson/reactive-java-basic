package com.rp.sec01.assignment;

import courseutil.Util;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        FileService.write("file02.txt", "test write file")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());

        FileService.delete("file02.txt")
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }
}
