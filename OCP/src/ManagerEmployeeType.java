public class ManagerEmployeeType implements EmployeeType {

    @Override
    public int payAmount(int salary, int bonus) {
        return salary + bonus;
    }
}