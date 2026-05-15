import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class BirthdayGreeter {

    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private final EmailService emailService;

    public BirthdayGreeter(
            EmployeeRepository employeeRepository,
            Clock clock,
            EmailService emailService
    ) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
        this.emailService = emailService;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();

        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(emailService::send);
    }

    private Email emailFor(Employee employee) {
        String message =
                String.format("Happy birthday, dear %s!", employee.getFirstName());

        return new Email(
                employee.getEmail(),
                "Happy birthday!",
                message
        );
    }

    // Main method added so the program can run
    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository() {
            @Override
            public List<Employee> findEmployeesBornOn(MonthDay monthDay) {

                List<Employee> employees = Arrays.asList(
                        new Employee(
                                "John",
                                "Doe",
                                LocalDate.of(1995, monthDay.getMonth(), monthDay.getDayOfMonth()),
                                "john.doe@email.com"
                        ),
                        new Employee(
                                "Jane",
                                "Smith",
                                LocalDate.of(1990, 1, 1),
                                "jane.smith@email.com"
                        )
                );

                return employees.stream()
                        .filter(employee ->
                                MonthDay.from(employee.getDateOfBirth()).equals(monthDay)
                        )
                        .toList();
            }
        };

        Clock clock = new Clock();

        EmailService emailService = new EmailSender();

        BirthdayGreeter greeter =
                new BirthdayGreeter(employeeRepository, clock, emailService);

        greeter.sendGreetings();
    }
}