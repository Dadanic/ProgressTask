package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal value;
    public static final Money ZERO = new Money(BigDecimal.valueOf(0.00));
    public static final Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static final Money HALF_DINAR = new Money(BigDecimal.valueOf(0.50));
    public static final Money DINAR = new Money(BigDecimal.valueOf(1.00));
    public static final Money FIVE_DINARS = new Money(BigDecimal.valueOf(5));
    public static final Money TEN_DINARS = new Money(BigDecimal.valueOf(10));

    public Money(BigDecimal value) {
        if(value.compareTo(BigDecimal.valueOf(0)) == -1){
            throw new IllegalArgumentException();
        }
         this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money add(Money money) {
        value = value.add(money.value);
        return this;
    }

    public boolean isLessThan(Money amount) {
        if(amount == null){
            return false;
        } else if (value.compareTo(amount.value) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public Money subtract(Money amount) {
        if(this.isLessThan(amount)){
            throw new IllegalArgumentException();
        }
        value = value.subtract(amount.value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Money){
            if (((Money)o).getValue().equals(this.value)) {
                return true;
            }
        }
        return super.equals(o);
    }

}
