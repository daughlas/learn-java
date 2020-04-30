public class Application {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 2000, 1988, 9, 3);
        staff[1] = new Employee("Peter", 3000, 1988, 9, 3);
        staff[2] = new Employee("Bruce", 4000, 1988, 9, 3);

        for (Employee e: staff) {
            System.out.println("name=" + e.getName() + " ,salary=" + e.getSalary());
        }

        Manager boss = new Manager("吕嘉文", 5000.00, 1988, 9, 3);
        boss.setBonus(3000);
        System.out.println("老板的工资是：" + boss.getSalary());
    }
}
