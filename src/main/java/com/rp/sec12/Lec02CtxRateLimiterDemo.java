package com.rp.sec12;

import com.rp.sec12.helper.BookService;
import com.rp.sec12.helper.UserService;
import courseutil.Util;
import reactor.util.context.Context;

public class Lec02CtxRateLimiterDemo {
    public static void main(String[] args) {
        BookService.getBook()
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }
}
