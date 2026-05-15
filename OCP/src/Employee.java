public class Employee {

    private int salary;
    private int bonus;
    private EmployeeType type;

    public Employee(int salary, int bonus, EmployeeType type) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
    }

    public int payAmount() {
        return type.payAmount(salary, bonus);
    }

    public static void main(String[] args) {

        Employee engineer = new Employee(
                5000,
                0,
                new EngineerEmployeeType()
        );

        Employee manager = new Employee(
                5000,
                2000,
                new ManagerEmployeeType()
        );

        System.out.println("Engineer Pay: " + engineer.payAmount());
        System.out.println("Manager Pay: " + manager.payAmount());
    }
}