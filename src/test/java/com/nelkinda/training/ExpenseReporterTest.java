package com.nelkinda.training;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static com.nelkinda.training.ExpenseType.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseReporterTest {
    private static final Date START_OF_EPOCH = new Date(0);
    private static final ExpenseReporter expenseReporter = new ExpenseReporter();

    @Test
    void legacyReport() {
        assertReport("Expenses Thu Jan 01 05:30:00 IST 1970\n" +
                "Breakfast	1000\t \n" +
                "Breakfast	1001	X\n" +
                "Dinner	5000\t \n" +
                "Dinner	5001	X\n" +
                "Car Rental	1000\t \n" +
                "Meal expenses: 12002\n" +
                "Total expenses: 13002\n",
                new Expense(BREAKFAST, 1000),
                new Expense(BREAKFAST, 1001),
                new Expense(DINNER, 5000),
                new Expense(DINNER, 5001),
                new Expense(CAR_RENTAL, 1000)
        );
    }

    @Test
    void lunchReport() {
        assertReport("Expenses Thu Jan 01 05:30:00 IST 1970\n" +
                "Lunch	2500\t \n" +
                "Lunch	2501	X\n" +
                "Meal expenses: 5001\n" +
                "Total expenses: 5001\n",
                new Expense(LUNCH, 2500),
                new Expense(LUNCH, 2501)
        );
    }

    private static void assertReport(final String expected, final Expense... expenses) {
        assertEquals(expected, expenseReporter.generateReport(START_OF_EPOCH, asList(expenses)));
    }
}
