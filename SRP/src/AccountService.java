public class AccountService {

    private final TransactionRepository transactionRepository;
    private final Clock clock;
    private final StatementPrinter statementPrinter;

    public AccountService(
            TransactionRepository transactionRepository,
            Clock clock,
            StatementPrinter statementPrinter
    ) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Transaction(clock.today(), amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(new Transaction(clock.today(), -amount));
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.all());
    }

    public static void main(String[] args) {
        TransactionRepository repository = new InMemoryTransactionRepository();
        Clock clock = new Clock();
        Console console = new Console();

        StatementFormatter formatter = new StatementFormatter();
        StatementPrinter printer = new StatementPrinter(console, formatter);

        AccountService accountService = new AccountService(repository, clock, printer);

        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);

        accountService.printStatement();
    }
}