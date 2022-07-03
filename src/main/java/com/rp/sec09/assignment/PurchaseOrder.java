package com.rp.sec09.assignment;

import com.github.javafaker.Book;
import courseutil.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private String category;
    private double price;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.category = Util.faker().commerce().department();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }
}
