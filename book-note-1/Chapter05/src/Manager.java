public class Manager extends Employee {
    private double bonus;

    /**
     *
     * @param name the employee's name
     * @param salary the employee's salary
     * @param year the employee's hire year
     * @param month the employee's hire month
     * @param day the employee's hire day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
