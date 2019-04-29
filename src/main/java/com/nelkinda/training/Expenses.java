package com.nelkinda.training;

import java.util.List;
import java.util.function.Predicate;

enum Expenses {
    ;

    static int sumAllExpenses(final List<Expense> expenses) {
        return sumWithFilter(expenses, expense -> true);
    }

    static int sumMealExpenses(final List<Expense> expenses) {
        return sumWithFilter(expenses, expense -> expense.type.isMeal);
    }

    static int sumWithFilter(final List<Expense> expenses, final Predicate<Expense> predicate) {
        return expenses.stream()
                .filter(predicate)
                .mapToInt(expense -> expense.amount)
                .sum();
    }
}
