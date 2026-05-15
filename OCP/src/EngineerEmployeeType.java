public class EngineerEmployeeType implements EmployeeType {

    @Override
    public int payAmount(int salary, int bonus) {
        return salary;
    }
}