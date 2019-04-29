package com.nelkinda.training;

class Expense {
    final ExpenseType type;
    final int amount;

    Expense(final ExpenseType type, final int amount) {
        this.type = type;
        this.amount = amount;
    }

    boolean isOverLimit() {
        return amount > type.limit;
    }
}
