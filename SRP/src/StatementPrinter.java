import java.util.List;

public class StatementPrinter {

    private final Console console;
    private final StatementFormatter formatter;

    public StatementPrinter(Console console, StatementFormatter formatter) {
        this.console = console;
        this.formatter = formatter;
    }

    public void print(List<Transaction> transactions) {
        console.printLine(formatter.header());

        formatter.format(transactions)
                .forEach(console::printLine);
    }
}