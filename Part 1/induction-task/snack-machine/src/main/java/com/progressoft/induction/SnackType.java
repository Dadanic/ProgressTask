package com.progressoft.induction;

import java.math.BigDecimal;

public enum SnackType {
    CHEWING_GUM(Money.HALF_DINAR, 0), CHIPS(Money.DINAR, 0), CHOCOLATE(new Money(BigDecimal.valueOf(2.0)), 0);

    private final Money price;
    private int quantity;

    SnackType(final Money price, final int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public Money getPrice(){
        return price;
    }
    public int quantity() {
        return quantity;
    }
    public static void subtractItem(SnackType snackType){
        snackType.quantity--;
    }
    public static void setDefaultVal(int quantity){
        CHEWING_GUM.quantity = quantity;
        CHIPS.quantity = quantity;
        CHOCOLATE.quantity = quantity;
    }
}
