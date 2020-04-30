import java.util.Random;
import java.time.*;

class Employee {
    private static int nextId;

    private int id;
    private String name;
    private double salary;
    private LocalDate hireDay;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    {
        id = nextId;
        nextId++;
    }

    public Employee(String name , double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName(){
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() { return hireDay; }

    public void raiseSalary(double byPercent) {
       double raise = salary * byPercent / 100;
       salary += raise;
    }
}