package com.progressoft.induction;

import java.math.BigDecimal;

public class SnackMachine {
    private Money moneyInside;
    private Money moneyInTransaction;
    public static final int DEFAULT_QUANTITY = 20;

    public SnackMachine() {
        moneyInside = new Money(Money.ZERO.getValue());
        moneyInTransaction = new Money(Money.ZERO.getValue());
        SnackType.setDefaultVal(DEFAULT_QUANTITY);
    }

    public Money moneyInside() {
        return moneyInside;
    }

    public Money buySnack(SnackType snackType) {
        if(snackType.quantity() <= 0){
            throw new IllegalStateException();
        }
        if(moneyInTransaction.getValue().compareTo(snackType.getPrice().getValue()) == -1) {
            throw new IllegalStateException();
        }
        moneyInTransaction = moneyInTransaction.subtract(snackType.getPrice());
        moneyInside = moneyInside.add(snackType.getPrice());
        SnackType.subtractItem(snackType);

        return moneyInTransaction;
    }

    public void insertMoney(Money amount){
        if(amount == null){
            throw new IllegalArgumentException();
        }
        if(amount.getValue().compareTo(BigDecimal.valueOf(0.25)) == 0 ||
                amount.getValue().compareTo(BigDecimal.valueOf(0.5)) == 0 ||
                amount.getValue().compareTo(BigDecimal.valueOf(1)) == 0 ||
                amount.getValue().compareTo(BigDecimal.valueOf(5)) == 0 ||
                amount.getValue().compareTo(BigDecimal.valueOf(10)) == 0) {
            moneyInTransaction = moneyInTransaction.add(amount);
        } else {
            throw new IllegalArgumentException();
        }
    }


    public Money moneyInTransaction() {
        switch (moneyInTransaction.getValue().toString()){
            case ("0.00"): return Money.ZERO;
            case ("0.25"): return Money.QUARTER_DINAR;
            case ("0.5"): return Money.HALF_DINAR;
            case ("1"): return Money.DINAR;
            case ("5"): return Money.FIVE_DINARS;
            case ("10"): return Money.TEN_DINARS;
        }
        return this.moneyInTransaction;
    }

    public SnackType chewingGums() {
        return SnackType.CHEWING_GUM;
    }
    public SnackType chips() {
        return SnackType.CHIPS;
    }
    public SnackType chocolates() {
        return SnackType.CHOCOLATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnackMachine that = (SnackMachine) o;
        return moneyInTransaction.equals(that.moneyInTransaction) && moneyInside.equals(that.moneyInside);
    }

}
