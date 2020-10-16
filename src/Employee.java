public class Employee extends Person {
    private String department;

    public Employee(String name, String department) {
        super(name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
    public static void main(String[] args) {
        Employee emp = new Employee("Peter Gibbons", "IT");
        System.out.println(emp.getName() + "works in " + emp.getDepartment());
    }

}
