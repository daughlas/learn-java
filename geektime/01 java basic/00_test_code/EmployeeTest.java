import java.time.*;

/**
 * EmployeeTest
 */
public class EmployeeTest {
  public static void main(String[] args) {
    Employee[] staff = new Employee[3];
    staff[0] = new Employee("lv", 1000, 1988, 7, 1);
    staff[1] = new Employee("jia", 2000, 1988, 8, 2);
    staff[2] = new Employee("wen", 3000, 1988, 9, 3);
    System.out.println(LocalDate.now());
    for (Employee e: staff) {
      e.raiseSalary(5);
    }

    for(Employee e : staff) {
      System.out.println(e);
      System.out.println("name="+ e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
    }
  }
  
}

class Employee {
  private String name;
  private double salary;
  private LocalDate hireDay;

  public Employee(String n, double s, int year, int month, int day) {
    name = n;
    salary = s;
    hireDay = LocalDate.of(year, month, day);
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public LocalDate getHireDay() {
    return hireDay;
  }

  public void raiseSalary(double byPercent) {
    double raise = salary * byPercent / 100;
    salary += raise;
  }
}