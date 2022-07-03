package com.rp.sec04;

import com.rp.sec03.helper.UserService;
import com.rp.sec04.helper.OrderService;
import courseutil.Util;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                //.filter(p -> p.getPrice() > 10)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
