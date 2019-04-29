package com.nelkinda.training;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.nelkinda.training.Expenses.sumAllExpenses;
import static com.nelkinda.training.Expenses.sumMealExpenses;

public class ExpenseReporter {
    private static String generateDetail(final Expense expense) {
        return expense.type.name + "\t" + expense.amount + "\t" + determineOverExpensesMarker(expense) + "\n";
    }

    private static String determineOverExpensesMarker(final Expense expense) {
        return expense.isOverLimit() ? "X" : " ";
    }

    public void printReport(final List<Expense> expenses) {
        System.out.println(generateReport(new Date(), expenses));
    }

    String generateReport(final Date date, final List<Expense> expenses) {
        return
                generateHeader(date) +
                generateBody(expenses) +
                generateFooter(expenses);
    }

    private String generateHeader(final Date date) {
        return "Expenses " + date + "\n";
    }

    private String generateFooter(final List<Expense> expenses) {
        return "Meal expenses: " + sumMealExpenses(expenses) + "\n"
                + "Total expenses: " + sumAllExpenses(expenses) + "\n";
    }

    private String generateBody(final List<Expense> expenses) {
        return expenses.stream()
                .map(ExpenseReporter::generateDetail)
                .collect(Collectors.joining());
    }
}
