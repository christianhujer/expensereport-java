package com.nelkinda.training;

enum ExpenseType {
    BREAKFAST("Breakfast", 1000, true),
    LUNCH("Lunch", 2500, true),
    DINNER("Dinner", 5000, true),
    CAR_RENTAL("Car Rental", Integer.MAX_VALUE, false),
    ;

    final String name;
    final int limit;
    final boolean isMeal;

    ExpenseType(final String name, final int limit, final boolean isMeal) {
        this.name = name;
        this.limit = limit;
        this.isMeal = isMeal;
    }
}
