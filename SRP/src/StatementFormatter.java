import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class StatementFormatter {

    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String AMOUNT_FORMAT = "#.00";

    public String header() {
        return STATEMENT_HEADER;
    }

    public List<String> format(List<Transaction> transactions) {
        AtomicInteger balance = new AtomicInteger(0);

        return transactions.stream()
                .map(transaction -> formatLine(
                        transaction,
                        balance.addAndGet(transaction.amount())
                ))
                .collect(toCollection(LinkedList::new))
                .reversed();
    }

    private String formatLine(Transaction transaction, int balance) {
        return MessageFormat.format(
                "{0} | {1} | {2}",
                formatDate(transaction.date()),
                formatNumber(transaction.amount()),
                formatNumber(balance)
        );
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return formatter.format(date);
    }

    private String formatNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(
                AMOUNT_FORMAT,
                DecimalFormatSymbols.getInstance(Locale.UK)
        );

        return decimalFormat.format(amount);
    }
}